package com.mapper;

import com.bean.User;
import com.bean.userInformation.ChangePasswordUser;
import com.bean.userInformation.FindPasswordUser;
import com.bean.userInformation.LoginUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Repository
public interface UserMapper {

    //登录并返回用户信息
    User loginUser(LoginUser loginUser);
    //更改密码
    int changePassword(ChangePasswordUser cpUser);
    //注册
    int register(User user);
    //找回密码
    int findPassword(FindPasswordUser fpUser);
    //更改昵称
    int changePetName(@Param("petName") String petName,@Param("id") Integer id);

    User getPetNameByUId(@Param("uId") Integer uId);
}
