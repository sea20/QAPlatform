package com.service;

import com.bean.careInformation.QueryCare;
import com.bean.result.Result;

import javax.servlet.http.HttpSession;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
public interface CareService {
    //查找关注了谁
    Result select(QueryCare queryCare);
    //我是否关注u2
    Result ifCare(Integer uId, HttpSession session);
    //关注uId
    Result careUser(Integer uId, boolean flag, HttpSession session);
}
