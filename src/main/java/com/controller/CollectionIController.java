package com.controller;

import com.bean.User;
import com.bean.careInformation.QueryCare;
import com.bean.collectionInformation.QueryCollection;
import com.bean.result.Result;
import com.service.CareService;
import com.service.CollectionService;
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
@Api(tags = "收藏controller")
@RequestMapping("/collection")
public class CollectionIController {

    @Autowired
    CollectionService collectionService;
    @ResponseBody
    @ApiOperation("收藏/取消收藏帖子")
    @PostMapping("/collectionUser/{qId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "flag",value = "收藏还是取消收藏(true:收藏 false:取消收藏)",paramType = "body",dataType = "boolean"),
            @ApiImplicitParam(name = "qId",value = "要收藏的帖子id",paramType = "path",dataType = "Integer")
    })
    public Result collectionUser(@PathVariable Integer qId, @RequestBody boolean flag, HttpSession session){
        return collectionService.collectionUser(qId,flag,session);
    }

        @ResponseBody
        @ApiOperation("查找我收藏了哪些帖子")
        @PostMapping("/select")
        @ApiImplicitParam(name = "queryCollection",value = "查询收藏信息",paramType = "body",dataType = "查询收藏信息")
        public Result careInformation(@RequestBody QueryCollection queryCollection){
            return collectionService.select(queryCollection);
    }

    @ResponseBody
    @ApiOperation("查询我是否收藏了qId")
    @PostMapping("/ifCollection/{qId}")
    @ApiImplicitParam(name = "qId",value = "帖子id",paramType = "path",dataType = "Integer")
    public Result ifCare(@PathVariable Integer qId,HttpSession session){
        return collectionService.ifCollection(qId,session);
    }
}
