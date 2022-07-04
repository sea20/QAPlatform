package com.service.impl;

import com.bean.LittleQuestion;
import com.bean.Question;
import com.bean.questionInformation.QueryQuestion;
import com.bean.result.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapper.CollectionMapper;
import com.mapper.LittleQuestionMapper;
import com.mapper.QuestionMapper;
import com.service.LittleQuestionService;
import com.service.QuestionService;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
public class LittleQuestionServiceImpl implements LittleQuestionService {
    @Autowired
    LittleQuestionMapper littleQuestionMapper;
    @Autowired
    CollectionMapper collectionMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ObjectMapper objectMapper;


    @Override
    public Result updateQuestion(LittleQuestion question) {
        int count;
        try {
            count =  littleQuestionMapper.updateQuestion(question.getqId(),question.getContent());
        }catch (Exception e){
            return R.Error();
        }
        if(count == 1){
            //缓存到redis
            //getQuestionByQid(question.getqId());
            //删除缓存
            redisTemplate.delete(question.getqId());
            return R.Ok();
        }
        return R.Error();
    }

    @Override
    public Result getQuestionByQid(Integer qid) {
        //从缓存中读取
        Object o = redisTemplate.opsForValue().get(qid+"");
        if(o == null){
            String id = UUID.randomUUID().toString();
                Boolean flag = redisTemplate.opsForValue().setIfAbsent("lock_" + qid, id, 5, TimeUnit.SECONDS);//5s
                if(flag == true){
                    LittleQuestion question = littleQuestionMapper.getQuestionByQid(qid);
                    if (question == null){
                        return R.Empty();
                    }
                    //缓存到redis id 为key
                    try {
                        redisTemplate.opsForValue().set(""+question.getqId(),objectMapper.writeValueAsString(question),60, TimeUnit.MINUTES);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    DefaultRedisScript script = new DefaultRedisScript();
                    String text = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
                    script.setScriptText(text);
                    redisTemplate.execute(script, Arrays.asList("lock_" + qid),id);
                }else{
                    try {
                        Thread.sleep(1000);
                        return getQuestionByQid(qid);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }

        if(o != null){
            try {
                //重置时间
                //redisTemplate.expire(qid+"",60,TimeUnit.MINUTES);
                return R.Ok().add("data",objectMapper.readValue((String) o,LittleQuestion.class));
            } catch (IOException e) {
                return R.Error();
            }
        }

        return R.Empty();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Result askQuestion(Question question) {
        int count;
        try {
            count =  littleQuestionMapper.askQuestion(question.getId(),question.getContent());
        }catch (Exception e){
            return R.Error();
        }
        if(count == 1){
            //getQuestionByQid(question.getId());
            return R.Ok();
        }
        return R.Error();
    }
}
