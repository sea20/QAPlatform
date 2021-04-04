package com.bean.userInformation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Maple
 * @Date: 2021/2/7
 */
@ApiModel(description = "找回密码用户",value = "找回密码")
public class FindPasswordUser {
    @ApiModelProperty(value = "登录名",example = "xusea")
    private String username;
    @ApiModelProperty(value = "新密码",example = "a123456a")
    private String newPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "FindPasswordUser{" +
                "username='" + username + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
