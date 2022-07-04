package com.service;

import com.bean.TagInformation.QueryTag;
import com.bean.careInformation.QueryCare;
import com.bean.result.Result;

import javax.servlet.http.HttpSession;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
public interface TagsService {
    //查找有哪些标签
    Result select();
    //根据标签查询
    Result queryQuestion(QueryTag queryTag);
}
