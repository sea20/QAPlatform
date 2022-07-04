package com.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class LittleQuestion {
    @ApiModelProperty(value = "帖子主键id",hidden = true)
    private Integer qId;
    @ApiModelProperty(value = "内容",example = "我是内容")
    private String content;

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
