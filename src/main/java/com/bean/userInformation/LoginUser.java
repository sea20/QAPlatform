package com.bean.userInformation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Maple
 * @Date: 2021/2/7
 */
@ApiModel(description = "登录信息",value = "登录信息")
public class LoginUser {
    @ApiModelProperty(value = "登录名",example = "xusea")
    private String username;
    @ApiModelProperty(value = "密码",example = "a123456a")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
