package com.service;

import com.bean.result.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
public interface HeadPictureService {
    //上传头像
    Result upload(MultipartFile file, Integer uId, HttpServletRequest request);
    //获取头像url
    Result getHeadPicture(Integer uId);
}
