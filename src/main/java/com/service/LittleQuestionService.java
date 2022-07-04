package com.service;

import com.bean.LittleQuestion;
import com.bean.Question;
import com.bean.questionInformation.QueryQuestion;
import com.bean.result.Result;

public interface LittleQuestionService {
    //更新帖子/问题
    Result updateQuestion(LittleQuestion question);
    //根据qid查询帖子
    Result getQuestionByQid(Integer qid);
    //提问
    Result askQuestion(Question question);
}
