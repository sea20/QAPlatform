package com.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@ApiModel(description = "二级评论",value = "二级评论")
public class CommentLv2 {
    @ApiModelProperty(value = "二级评论主键id",hidden = true)
    private Integer id;
    @ApiModelProperty(value = "一级评论id",example = "1")
    private Integer c1Id;
    @ApiModelProperty(value = "评论者id",hidden = true)
    private Integer uId;
    @ApiModelProperty(value = "评论内容",example = "二级评论")
    private String comment;
    @ApiModelProperty(value = "评论时间",hidden = true)
    private Date createTime;
    @ApiModelProperty(value = "被评论者Id",example = "1")
    private Integer udId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getC1Id() {
        return c1Id;
    }

    public void setC1Id(Integer c1Id) {
        this.c1Id = c1Id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUdId() {
        return udId;
    }

    public void setUdId(Integer udId) {
        this.udId = udId;
    }
}
