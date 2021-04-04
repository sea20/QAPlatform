package com.bean.userInformation;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Maple
 * @Date: 2021/2/7
 */
@ApiModel(description = "修改密码信息",value = "修改密码信息")
public class ChangePasswordUser {
    @ApiModelProperty(value = "登录名",example = "xusea")
    private String username;
    @ApiModelProperty(value = "新密码",example = "123")
    private String newPassword;
    @ApiModelProperty(value = "老密码",example = "a123456a")
    private String oldPassword;

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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    @Override
    public String toString() {
        return "ChangePassword{" +
                "username='" + username + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                '}';
    }
}
