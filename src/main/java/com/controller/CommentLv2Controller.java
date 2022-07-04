package com.controller;

import com.bean.CommentLv1;
import com.bean.CommentLv2;
import com.bean.result.Result;
import com.service.CommentLv1Service;
import com.service.CommentLv2Service;
import com.utils.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Controller
@Api(tags = "二级评论Controller")
@RequestMapping("/commentLv2")
public class CommentLv2Controller {
    @Autowired
    CommentLv2Service commentLv2Service;

    @PostMapping("/postCommentLv2")
    @ApiOperation("发表二级评论")
    @ApiImplicitParam(name = "commentLv2",value = "二级评论" ,paramType ="body",dataType = "二级评论")
    @ResponseBody
    public Result postCommentLv1(@RequestBody CommentLv2 commentLv2, HttpServletRequest request){
        return commentLv2Service.postCommentLv2(commentLv2,request);
    }
    @GetMapping("/getAllC2/{c1Id}/{uId}")
    @ApiOperation("根据一级评论 uid（uid可有可无）查询所有二级评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "c1Id",value = "一级评论id" ,paramType ="path",dataType = "int"),
            @ApiImplicitParam(name = "uId",value = "用户id" ,paramType ="path",dataType = "int")
    })
    @ResponseBody
    public Result selectAllByc1Id(@PathVariable Integer c1Id,@PathVariable(required = false) Integer uId){
        return commentLv2Service.selectAllByc1Id(c1Id,uId);
    }


}
