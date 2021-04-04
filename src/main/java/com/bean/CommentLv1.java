package com.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@ApiModel(description = "一级评论",value = "一级评论")
public class CommentLv1 {
    @ApiModelProperty(value = "一级评论主键id",hidden = true)
    private Integer id;
    @ApiModelProperty(value = "帖子id",example = "1")
    private Integer qId;
    @ApiModelProperty(value = "评论者id",hidden = true)
    private Integer uId;
    @ApiModelProperty(value = "评论内容",example = "一级评论")
    private String comment;
    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date createTime;
    @ApiModelProperty(value = "二级评论数量 默认0",hidden = true)
    private Integer commentNum;
    @ApiModelProperty(value = "点赞数量 默认0",hidden = true)
    private Integer likeNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
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

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }
}
