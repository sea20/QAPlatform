package com.controller;

import com.bean.TagInformation.QueryTag;
import com.bean.careInformation.QueryCare;
import com.bean.questionInformation.QueryQuestion;
import com.bean.result.Result;
import com.service.CareService;
import com.service.TagsService;
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
@Api(tags = "标签controller")
@RequestMapping("/tags")
public class TagsController {

    @Autowired
    TagsService tagsService;
    @ResponseBody
    @ApiOperation("查找标签")
    @PostMapping("/select")
    public Result selectTags(){
        return tagsService.select();
    }



    @ApiOperation("搜索帖子/问题通过tag")
    @PostMapping("/query")
    @ResponseBody
    public Result queryQuestions(@RequestBody QueryTag queryTag){
        return tagsService.queryQuestion(queryTag);
    }
}
