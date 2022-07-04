package com.bean.TagInformation;

import io.swagger.annotations.ApiModelProperty;

public class QueryTag {
    @ApiModelProperty(value = "标签id",example = "1")
    Integer id;
    @ApiModelProperty(value = "当前页号",example = "1")
    Integer current;
    @ApiModelProperty(value = "每页多少条数据",example = "10")
    Integer limit;
    @ApiModelProperty(value = "排序类型 1:按照时间降序排列 2:按照点赞数降序排列",example = "1")
    String sortType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}
