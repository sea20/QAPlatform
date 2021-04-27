package com.service.impl;

import com.bean.Question;
import com.bean.questionInformation.QueryQuestion;
import com.bean.result.Result;
import com.mapper.QuestionMapper;
import com.mapper.UserMapper;
import com.service.QuestionService;
import com.utils.result.R;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;


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
    public Result askQuestion(Question question) {
        int count;
        try {
            count =  questionMapper.askQuestion(question);
        }catch (Exception e){
            return R.Error();
        }
        if(count == 1){
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
    public Result delQuestion(Integer qId,Integer uId) {
        int count = questionMapper.delQuestion(qId,uId);
        if(count == 1){
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
        if(name == null || name.equals("")){
             //没有名字
             list = questionMapper.getAll(qQuery);
        }else {
            if(qQuery.getType() == 1){
                switch (qQuery.getSortType()){
                    case "1":qQuery.setSortType("order by update_time desc");break;
                    case "2":qQuery.setSortType("order by like_num desc");
                }
            }
            //有名字
            list = questionMapper.getAllByqQuery(qQuery);
        }
        if (list == null || list.size() == 0){
            return R.Empty();
        }else {
            return R.Ok().add("data",list);
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

    @Override
    public Result getQuestionByQid(Integer qid) {
        Question question = questionMapper.getQuestionByQid(qid);
        if (question == null){
            return R.Empty();
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
}
