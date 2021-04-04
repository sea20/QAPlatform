package com.bean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@ApiModel(description = "帖子/问题",value = "帖子")
public class Question {
    @ApiModelProperty(value = "帖子主键id",hidden = true)
    private Integer id;
    @ApiModelProperty(value = "标题",example = "我是标题")
    private String title;
    @ApiModelProperty(value = "内容",example = "没错我就是内容")
    private String content;
    @ApiModelProperty(value = "状态",hidden = true)
    private Integer state;
    @ApiModelProperty(value = "点赞数量",hidden = true)
    private Integer likeNum;
    @ApiModelProperty(value = "评论数量",hidden = true)
    private Integer commentNum;
    @ApiModelProperty(value = "帖子的用户id",hidden = true)
    private Integer uId;
    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date createTime;
    @ApiModelProperty(value = "最后一次更新时间",hidden = true)
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", likeNum=" + likeNum +
                ", commentNum=" + commentNum +
                ", u_Id=" + uId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
