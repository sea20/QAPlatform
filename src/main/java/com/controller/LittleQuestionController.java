package com.controller;

import com.bean.LittleQuestion;
import com.bean.Question;
import com.bean.User;
import com.bean.questionInformation.QueryQuestion;
import com.bean.result.Result;
import com.service.LittleQuestionService;
import com.service.QuestionService;
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
@Api(tags = "缩略帖子Controller")
@RequestMapping("/littleQuestion")
public class LittleQuestionController {
    @Autowired
    LittleQuestionService littleQuestionService;
    @Autowired
    QuestionService questionService;
    @ApiOperation("修改帖子")
    @ApiImplicitParam(name = "littleQuestion" ,value = "帖子信息",paramType = "body" ,dataType = "帖子")
    @PostMapping("/update")
    @ResponseBody
    public Result updateQuestion(@RequestBody LittleQuestion question, HttpSession session){
        return littleQuestionService.updateQuestion(question);
    }

    @ApiOperation("根据qid查询帖子")
    @ApiImplicitParam(name = "qid" ,value = "帖子id",paramType = "path" ,dataType = "int")
    @PostMapping("/getQuestionByQid/{qid}")
    @ResponseBody
    public Result getQuestionByQid(@PathVariable Integer qid){
        //system.out.println(qid);
        questionService.scan(qid);
        return littleQuestionService.getQuestionByQid(qid);
    }
}
