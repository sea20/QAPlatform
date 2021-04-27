package com.mapper;

import com.bean.CommentLv1;
import com.bean.commentInformation.QueryComment1;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Repository
public interface CommentLv1Mapper {
    //点赞
    int support(@Param("cId") Integer cId);
    //查询所有
    List selectAllByQueryComment1(QueryComment1 queryComment1);
    //发表一级评论
    int postCommentLv1(CommentLv1 commentLv1);

    int addCommentLv1Num(@Param("c1Id") Integer c1Id);
}
