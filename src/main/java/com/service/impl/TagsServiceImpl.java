package com.service.impl;

import com.bean.Care;
import com.bean.Question;
import com.bean.TagInformation.QueryTag;
import com.bean.Tags;
import com.bean.User;
import com.bean.careInformation.QueryCare;
import com.bean.result.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapper.CareMapper;
import com.mapper.TagsMapper;
import com.mapper.UserMapper;
import com.service.CareService;
import com.service.TagsService;
import com.utils.result.R;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Service
public class
TagsServiceImpl implements TagsService {
    @Autowired
    TagsMapper tagsMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ObjectMapper objectMapper;
    @Override
    public Result select() {
        List select = tagsMapper.select();
        if(select != null && select.size() >= 0) {
            return R.Ok().add("data",select);
        }else{
            return R.Empty();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Integer qId, Integer tagId) {
        tagsMapper.insert(qId,tagId);
    }
    //根据标签查询
    @Override
    public Result queryQuestion(QueryTag qQuery) {
            List<Question> cache = new ArrayList();

            cache = redisTemplate.opsForList().range("tag"+qQuery.getId(), 0, -1);

            if(cache ==null || cache.size() <= 0){//没缓存
                String id = UUID.randomUUID().toString();
                String key = "lock_"+qQuery.getSortType()+"tag";
                Boolean flag = redisTemplate.opsForValue().setIfAbsent(key, id, 5, TimeUnit.SECONDS);//5s
                if(flag == true){//得到锁 去mysql搜索
                    Integer current = qQuery.getCurrent();
                    Integer limit = qQuery.getLimit();
                    qQuery.setCurrent((current-1)*limit);
                    List list = null;
                    Integer size = null;
                    switch (qQuery.getSortType()){
                        case "1":qQuery.setSortType("order by update_time desc");break;
                        case "2":qQuery.setSortType("order by like_num desc");
                    }

                    list = tagsMapper.selectQuestionId(qQuery);
                    if(list == null || list.size() == 0) {
                        //没有搜到
                        //释放锁 返回empty
                        DefaultRedisScript script = new DefaultRedisScript();
                        String text = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
                        script.setScriptText(text);
                        redisTemplate.execute(script, Arrays.asList("lock_"+"home_page_list"),id);
                        return R.Empty();
                    }

                    redisTemplate.opsForList().rightPushAll(key,cache);
                    redisTemplate.expire(key,2,TimeUnit.SECONDS);
                }else{
                    try {
                        Thread.sleep(1000);
                        return queryQuestion(qQuery);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return R.Error();
                    }
                }
            }
        if (cache == null || cache.size() == 0){
            return R.Empty();
        }else {
            return R.Ok().add("data",cache).add("size",cache.size());
        }
    }
}
