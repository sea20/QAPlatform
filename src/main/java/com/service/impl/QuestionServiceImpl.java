package com.service.impl;

import com.bean.Question;
import com.bean.questionInformation.QueryQuestion;
import com.bean.result.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapper.CollectionMapper;
import com.mapper.QuestionMapper;
import com.mapper.TagsMapper;
import com.mapper.UserMapper;
import com.service.QuestionService;
import com.utils.result.R;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    CollectionMapper collectionMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    TagsMapper tagsMapper ;
    /*@Before
    public void before(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //System.out.println(userMapper);
        SqlSessionTemplate sqlSession = (SqlSessionTemplate) context.getBean("sqlSession");
        questionMapper = sqlSession.getMapper(QuestionMapper.class);
    }*/
   /* @Test
    public void testQueryQuestions(){
        Question question = new Question();
        question.setTitle("标题");
        question.setContent("内容");
        question.setuId(1);
        Result result = this.askQuestion(question);
        System.out.println(result);
    }*/
    @Override
    @Transactional
    public Result askQuestion(Question question,Integer tagId) {
        int count;
        try {
            count =  questionMapper.askQuestion(question);
            if(tagId!=null){
                tagsMapper.insert(question.getId(),tagId);
            }
        }catch (Exception e){
            return R.Error();
        }
        if(count == 1){
            //缓存到redis
            getQuestionByQid(question.getId());
            return R.Ok();
        }
        return R.Error();
    }
    /* @Test
    public void testQueryQuestions(){
         Result result = this.delQuestion(3, 5);
         System.out.println(result);
     }*/

    @Override
    @Transactional
    public Result delQuestion(Integer qId,Integer uId) {
        int count = questionMapper.delQuestion(qId,uId);
        if(count == 1){
            collectionMapper.deCollectionByQid(qId);
            redisTemplate.delete(""+qId);
            return R.Ok();
        }
        return R.Error("删除失败");
    }

   /* @Test
    public void testQueryQuestions(){
        QueryQuestion query = new QueryQuestion();
        query.setLimit(5);
        query.setCurrent(0);
        query.setqName("标题");
        query.setSortType("1");
        query.setType(1);
        Result result = this.queryQuestions(query);
        System.out.println(result);
    }*/
    @Override
    public Result queryQuestions(QueryQuestion qQuery) {
        Integer current = qQuery.getCurrent();
        Integer limit = qQuery.getLimit();
        qQuery.setCurrent((current-1)*limit);
        String name = qQuery.getqName();
        List list = null;
        Integer size = null;

        if(name == null || name.equals("")){
            List<String> cache = new ArrayList();
             //没有名字
            cache = redisTemplate.opsForList().range("home_page_list", 0, -1);

            if(cache ==null || cache.size() <= 0){//没缓存
                String id = UUID.randomUUID().toString();
                Boolean flag = redisTemplate.opsForValue().setIfAbsent("lock_"+"home_page_list", id, 5, TimeUnit.SECONDS);//5s
                if(flag == true){
                    list = questionMapper.getAll(qQuery);
                    if(list == null || list.size() == 0) {
                        //没有搜到
                        //释放锁 返回empty
                        DefaultRedisScript script = new DefaultRedisScript();
                        String text = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
                        script.setScriptText(text);
                        redisTemplate.execute(script, Arrays.asList("lock_"+"home_page_list"),id);
                        return R.Empty();
                    }
                    for (Object o : list) {
                        try {
                            cache.add(objectMapper.writeValueAsString(o));
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }
                    }
                    redisTemplate.opsForList().rightPushAll("home_page_list",cache);
                    redisTemplate.expire("home_page_list",2,TimeUnit.SECONDS);
                }else{
                    try {
                        Thread.sleep(1000);
                        return queryQuestions(qQuery);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return R.Error();
                    }
                }
            }else{//有缓存
                list = new ArrayList();
                for (String s : cache) {
                    try {
                        list.add(objectMapper.readValue(s,Question.class));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            size = questionMapper.getAllSize();
        }else {
            if(qQuery.getType() == 1){
                switch (qQuery.getSortType()){
                    case "1":qQuery.setSortType("order by update_time desc");break;
                    case "2":qQuery.setSortType("order by like_num desc");
                }
            }
            //有名字
            list = questionMapper.getAllByqQuery(qQuery);
            size = questionMapper.getAllByqQuerySize(qQuery);
        }
        if (list == null || list.size() == 0){
            return R.Empty();
        }else {
            size = size == null ? 0 : size;
            return R.Ok().add("data",list).add("size",size);
        }
    }
    /* @Test
        public void testSupport(){
         Result support = this.support(1, false);
         System.out.println(support);
     }*/
    @Override
    public Result support(Integer qId, Boolean flag) {
        int count = 0;
        if (flag == true){
            //点赞
            count = 1;
        }else {
            //取消点赞
            count = -1;
        }
        count = questionMapper.support(qId,count);
        if(count == 1){
            return R.Ok();
        }
        return R.Error("点赞失败");
    }


    //此方法已经删除
    @Override
    public Result getQuestionByQid(Integer qid) {
        //从缓存中读取
        Object o = redisTemplate.opsForValue().get(qid+"");
        if(o != null){
            try {
                //重置时间
                redisTemplate.expire(qid+"",60,TimeUnit.MINUTES);
                return R.Ok().add("data",objectMapper.readValue((String) o,Question.class));
            } catch (IOException e) {
                return R.Error();
            }
        }


        Question question = questionMapper.getQuestionByQid(qid);
        if (question == null){
            return R.Empty();
        }
        //缓存到redis id 为key
        try {
            redisTemplate.opsForValue().set(""+question.getId(),objectMapper.writeValueAsString(question),60, TimeUnit.MINUTES);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return R.Ok().add("data",question);
    }

    @Override
    public Result getQuestionByUid(Integer uid) {
        List<Question> list = questionMapper.getQuestionByUid(uid);
        if (list == null || list.size() == 0){
            return R.Empty();
        }
        return R.Ok().add("data",list);
    }

    @Override
    public Result scan(int qId) {
        int count = questionMapper.scan(qId);
        if(count == 0) return R.Error();
        return R.Ok();
    }
}
