package com.mapper;

import com.bean.collectionInformation.QueryCollection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Repository
public interface CollectionMapper {
    //收藏
    int collection(@Param("qId") Integer qId,@Param("uId") Integer uId);
    //取消收藏
    int deCollection(@Param("qId") Integer qId,@Param("uId") Integer uId);
    //是否收藏
    int ifCollection(@Param("qId") Integer qId,@Param("uId") Integer uId);
    //查询我收藏的
    List select(QueryCollection queryCollection);
    //查询我收藏的个数
    Integer selectSize(QueryCollection queryCollection);
    //删除收藏(因为帖子被删除了)
    void deCollectionByQid(@Param("qId") Integer qId);
}
