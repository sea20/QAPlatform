package com.service;

import com.bean.collectionInformation.QueryCollection;
import com.bean.result.Result;

import javax.servlet.http.HttpSession;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
public interface CollectionService {
    //收藏/取消收藏
    Result collectionUser(Integer qId, boolean flag, HttpSession session);
    //查看我收藏了哪些帖子
    Result select(QueryCollection queryCollection);
    //查看我是否收藏了qid
    Result ifCollection(Integer qId, HttpSession session);
}
