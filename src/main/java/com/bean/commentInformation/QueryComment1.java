package com.bean.commentInformation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Maple
 * @Date: 2021/4/9
 */
@ApiModel(description = "查询一级评论信息",value = "查询一级评论信息")
public class QueryComment1 {
    @ApiModelProperty(value = "帖子id",example = "1")
    Integer qId;
    @ApiModelProperty(value = "当前页号",example = "1")
    Integer current;
    @ApiModelProperty(value = "每页多少条数据",example = "10")
    Integer limit;


    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
