package com.bean;

import io.swagger.annotations.ApiModelProperty;

public class Tags {
    @ApiModelProperty(value = "帖子主键id",hidden = true)
    int id;
    @ApiModelProperty(value = "内容",example = "我是标签内容")
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
