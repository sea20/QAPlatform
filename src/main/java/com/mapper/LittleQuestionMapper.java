package com.mapper;

import com.bean.LittleQuestion;
import com.bean.Question;
import com.bean.questionInformation.QueryQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LittleQuestionMapper {
    //更新帖子
    int updateQuestion(@Param("qId") Integer qId,@Param("content") String content);
    //根据qid查询帖子
    LittleQuestion getQuestionByQid(@Param("qId") Integer qId);
    //插入
    int askQuestion(@Param("qId") Integer qId,@Param("content") String content);
}
