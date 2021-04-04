package com.service;

import com.bean.CommentLv2;
import com.bean.result.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
public interface CommentLv2Service {
    //查找所有2级评论
    Result selectAllByc1Id(Integer c1Id);
    //发表二级评论
    Result postCommentLv2(CommentLv2 commentLv2, HttpServletRequest request);
}
