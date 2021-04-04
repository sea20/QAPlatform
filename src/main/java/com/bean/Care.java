package com.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@ApiModel(description = "关注信息")
public class Care {
    //关注者id
    @ApiModelProperty(value = "关注者id")
    private Integer uId;
    //被关注者id
    @ApiModelProperty(value = "被关注着id")
    private Integer udId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getUdId() {
        return udId;
    }

    public void setUdId(Integer udId) {
        this.udId = udId;
    }
}
