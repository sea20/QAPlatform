package com.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@ApiModel(description = "用户信息",value = "用户信息")
public class User {
    //用户id主键
    @ApiModelProperty(value = "用户id主键",hidden = true)
    private Integer id;
    //用户登录名
    @ApiModelProperty(value = "用户登录名",example = "xusea")
    private String username;
    //密码
    @ApiModelProperty(value = "密码",example = "a123456a")
    private String password;
    //昵称
    @ApiModelProperty(value = "昵称" ,example = "安小然")
    private String petName;
    //邮箱
    @ApiModelProperty(value = "邮箱",example = "1193569029@qq.com")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", petName='" + petName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
