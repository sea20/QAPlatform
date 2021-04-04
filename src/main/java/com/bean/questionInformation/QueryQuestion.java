package com.bean.questionInformation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Maple
 * @Date: 2021/2/7
 */
@ApiModel(description = "帖子查询信息",value = "帖子查询信息")
public class QueryQuestion {
    @ApiModelProperty(value = "查询类型 1:模糊查询",example = "1")
    private Integer type;
    @ApiModelProperty(value = "排序类型 1:按照时间降序排列 2:按照点赞数降序排列",example = "1")
    String sortType;
    @ApiModelProperty(value = "帖子/问题名字",example = "问题1")
    String qName;
    @ApiModelProperty(value = "第几页",example = "1")
    Integer current;
    @ApiModelProperty(value = "每页几条",example = "10")
    Integer limit;
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
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

    @Override
    public String toString() {
        return "QuestionQuery{" +
                "type=" + type +
                ", sortType='" + sortType + '\'' +
                ", qName='" + qName + '\'' +
                ", current=" + current +
                ", limit=" + limit +
                '}';
    }
}
