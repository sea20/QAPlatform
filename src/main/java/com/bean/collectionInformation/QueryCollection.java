package com.bean.collectionInformation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Maple
 * @Date: 2021/2/14
 */
@ApiModel(description = "查询收藏信息",value = "查询收藏信息")
public class QueryCollection {
    @ApiModelProperty(value = "用户id",example = "1")
    Integer uId;
    @ApiModelProperty(value = "当前页号",example = "1")
    Integer current;
    @ApiModelProperty(value = "每页多少条数据",example = "10")
    Integer limit;
    @ApiModelProperty(value = "查询类型(1:我收藏了哪些帖子)",example = "1")
    Integer type;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "QueryCollection{" +
                "uid=" + uId +
                ", current=" + current +
                ", limit=" + limit +
                ", type=" + type +
                '}';
    }
}

