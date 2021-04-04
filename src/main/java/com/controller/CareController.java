package com.controller;

import com.bean.careInformation.QueryCare;
import com.bean.result.Result;
import com.service.CareService;
import com.utils.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Controller
@Api(tags = "关注controller")
@RequestMapping("/care")
public class CareController {

    @Autowired
    CareService careService;


    @ResponseBody
    @ApiOperation("关注/取消关注用户")
    @PostMapping("/careUser/{uId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "flag",value = "关注还是取消关注(true:关注 false:取消关注)",paramType = "body",dataType = "boolean"),
            @ApiImplicitParam(name = "uId",value = "要关注的用户id",paramType = "path",dataType = "Integer")
    })
    public Result careUser(@PathVariable Integer uId, @RequestBody boolean flag, HttpSession session){

        return careService.careUser(uId,flag,session);
    }

    @ResponseBody
    @ApiOperation("查找我关注了谁/谁关注了我")
    @PostMapping("/select")
    @ApiImplicitParam(name = "queryCare",value = "查询关注信息",paramType = "body",dataType = "查询关注信息")

    public Result careInformation(@RequestBody QueryCare queryCare){
        return careService.select(queryCare);
    }


    @ResponseBody
    @ApiOperation("我是否关注了uid")
    @PostMapping("/ifCare/{uId}")
    @ApiImplicitParam(name = "uId",value = "关注用户id",paramType = "path",dataType = "Integer")
    public Result ifCare(@PathVariable Integer uId,HttpSession session){

        return careService.ifCare(uId,session);
    }

}
