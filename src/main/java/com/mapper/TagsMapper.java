package com.mapper;

import com.bean.Question;
import com.bean.TagInformation.QueryTag;
import com.bean.careInformation.QueryCare;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Repository
public interface TagsMapper {
    //查看标签
    List select();
    //根据标签查帖子id
    List<Question> selectQuestionId(@Param("queryTag")QueryTag queryTag);

    void insert(@Param("queryTag")Integer qId, @Param("queryTag")Integer tagId);
}
