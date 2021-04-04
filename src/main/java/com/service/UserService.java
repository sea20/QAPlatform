package com.service;

import com.bean.User;
import com.bean.userInformation.ChangePasswordUser;
import com.bean.userInformation.FindPasswordUser;
import com.bean.userInformation.LoginUser;
import com.bean.result.Result;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
public interface UserService {
    //登录
    Result login(LoginUser loginUser, HttpServletRequest request);
    //修改密码
    Result changePassword(ChangePasswordUser cpUser, HttpServletRequest request);
    //注册
    Result register(User user, String code,HttpServletRequest request);
    //找回密码
    Result findPassword(FindPasswordUser fpUser,String code,HttpServletRequest request);

    //改昵称
    Result changePetName(String petName, HttpServletRequest request);
    //根据Uid获取用户名
    Result getPetNameByUId(Integer uId);
}
