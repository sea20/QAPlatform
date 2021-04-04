package com.mapper;

import com.bean.Question;
import com.bean.questionInformation.QueryQuestion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Repository
public interface QuestionMapper {
    //没名字
    List getAll(QueryQuestion qQuery);
    //有名字
    List getAllByqQuery(QueryQuestion qQuery);
    //点赞/取消点赞
    int support(@Param("qId") Integer qId,@Param("count") int count);
    //删除帖子
    int delQuestion(@Param("qId") Integer qId,@Param("uId") Integer uId);
    //添加帖子/提问
    int askQuestion(Question question);
    //根据qid查询帖子
    Question getQuestionByQid(@Param("qId") Integer qId);
}
