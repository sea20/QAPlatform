package com.bean.careInformation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * @Auther: Maple
 * @Date: 2021/2/14
 */
@ApiModel(description = "查询关注信息",value = "查询关注信息")
public class QueryCare {
    @ApiModelProperty(value = "用户id",example = "1")
    Integer uId;
    @ApiModelProperty(value = "当前页号",example = "1")
    Integer current;
    @ApiModelProperty(value = "每页多少条数据",example = "10")
    Integer limit;
    @ApiModelProperty(value = "查询类型(1:谁关注了我 2:我关注了谁)",example = "1")
    Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


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
    @Override
    public String toString() {
        return "QueryCare{" +
                "uid=" + uId +
                ", current=" + current +
                ", limit=" + limit +
                ", type=" + type +
                '}';
    }

}
