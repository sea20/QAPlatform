package com.mapper;

import com.bean.CommentLv2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Repository
public interface CommentLv2Mapper {
    //根据一级评论id查找所有二级评论
    List selectAllByc1Id(@Param("c1Id") Integer c1Id);
    //发表二级评论
    int postCommentLv2(CommentLv2 commentLv2);
}
