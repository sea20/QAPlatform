package com.controller;

import com.bean.CommentLv1;
import com.bean.commentInformation.QueryComment1;
import com.bean.result.Result;
import com.service.CommentLv1Service;
import com.utils.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Controller
@Api(tags = "一级评论controller")
@RequestMapping("/commentLv1")
public class CommentLv1Controller {
    @Autowired
    CommentLv1Service commentLv1Service;

    @PostMapping("/postCommentLv1")
    @ApiOperation("发表一级评论")
    @ApiImplicitParam(name = "commentLv1",value = "一级评论" ,paramType ="body",dataType = "一级评论")
    @ResponseBody
    public Result postCommentLv1(@RequestBody CommentLv1 commentLv1, HttpServletRequest request){
        return commentLv1Service.postCommentLv1(commentLv1,request);
    }

    @PostMapping("/getAllC1")
    @ApiOperation("根据pid uid查询所有一级评论(uid可有可无)")
    @ApiImplicitParam(name = "queryComment1",value = "查询一级评论信息",paramType = "body",dataType = "查询一级评论信息")
    @ResponseBody
    public Result selectAllByPid(@RequestBody QueryComment1 queryComment1){
        return commentLv1Service.selectAllByPid(queryComment1);
    }

    @ApiOperation("点赞一级评论")
    @GetMapping("/supportC1/{cId}")
    @ApiImplicitParam(name = "cId",value = "一级评论id" ,paramType ="path",dataType = "int")
    @ResponseBody
    public Result support(@PathVariable Integer cId){
        return commentLv1Service.support(cId);
    }
}
