package com.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@ApiModel("头像表")
public class HeadPicture {
    @ApiModelProperty("用户id")
    private Integer uId;
    @ApiModelProperty("头像文件名字")
    private String pName;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
}
