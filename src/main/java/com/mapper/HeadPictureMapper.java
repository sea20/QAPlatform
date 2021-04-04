package com.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Repository
public interface HeadPictureMapper {
    int upload(@Param("uId") Integer uId,@Param("newFileName") String fileName);
    String getOldFileName(Integer uId);
}
