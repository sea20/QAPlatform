package com.mapper;

import com.bean.careInformation.QueryCare;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Repository
public interface CareMapper {

    List select(QueryCare queryCare);

    int ifCare(@Param("uId") Integer uId,@Param("myUId") Integer myUId);

    int careUser(@Param("uId") Integer uId,@Param("myUId") Integer myUId);

    int delCareUser(@Param("uId") Integer uId, @Param("myUId") Integer myUId);
}
