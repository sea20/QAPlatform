package com.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@ApiModel(description = "收藏信息")
public class Collection {
    @ApiModelProperty("收藏者id")
    private Integer uId;
    @ApiModelProperty("收藏的帖子的id")
    private Integer qId;
    @ApiModelProperty("收藏时间")
    private Date createTime;
    @ApiModelProperty(value = "帖子信息",hidden = true)
    Question question;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "Collection{" +
                "uId=" + uId +
                ", qId=" + qId +
                ", createTime=" + createTime +
                ", question=" + question +
                '}';
    }
}
