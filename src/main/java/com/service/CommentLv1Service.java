package com.service;

import com.bean.CommentLv1;
import com.bean.commentInformation.QueryComment1;
import com.bean.result.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
public interface CommentLv1Service {
    //点赞一级评论
    Result support(Integer cId);
    //跟俊pid查询一级评论
    Result selectAllByPid(QueryComment1 queryComment1);
    //发表一级评论
    Result postCommentLv1(CommentLv1 commentLv1, HttpServletRequest request);
}
