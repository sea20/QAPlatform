package com.service;

import com.bean.Question;
import com.bean.questionInformation.QueryQuestion;
import com.bean.result.Result;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */

public interface QuestionService {
    //提问
    Result askQuestion(Question question,Integer tagId);
    //删除帖子/问题
    Result delQuestion(Integer qid,Integer uId);
    //查询帖子/问题
    Result queryQuestions(QueryQuestion qQuery);
    //是点赞/取消点赞
    Result support(Integer qId, Boolean flag);
    //根据qid查询帖子
    Result getQuestionByQid(Integer qid);
    //根据uid查询帖子
    Result getQuestionByUid(Integer uid);
    //添加浏览量
    Result scan(int qId);
}
