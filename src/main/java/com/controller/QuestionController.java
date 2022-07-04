package com.controller;

import com.bean.Question;
import com.bean.User;
import com.bean.questionInformation.QueryQuestion;
import com.bean.result.Result;
import com.service.QuestionService;
import com.thread.Scan;
import com.thread.Support;
import com.utils.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Controller
@Api(tags = "帖子Controller")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;


    @ApiOperation("发表帖子/提问")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "question" ,value = "帖子信息",paramType = "body" ,dataType = "帖子"),
            @ApiImplicitParam(name = "tagId",value = "标签id",paramType = "path",dataType = "Integer")
    })
    @PostMapping("/submit")
    @ResponseBody
    public Result askQuestion(@RequestBody Question question,@PathVariable(required = false) Integer tagId, HttpSession session){
        User user = (User) session.getAttribute("user");
        question.setuId(user.getId());
        return questionService.askQuestion(question,tagId);
    }


    @ApiOperation("删除帖子")
    @ApiImplicitParam(name = "qid" ,value = "帖子id",paramType = "path" ,dataType = "int")
    @DeleteMapping("/delete/{qid}")
    @ResponseBody
    public Result changePassword(@PathVariable Integer qid,HttpSession session){
        User user = (User) session.getAttribute("user");
        return questionService.delQuestion(qid,user.getId());
    }

    @ApiOperation("根据qid查询帖子")
    @ApiImplicitParam(name = "qid" ,value = "帖子id",paramType = "path" ,dataType = "int")
    @PostMapping("/getQuestionByQid/{qid}")
    @ResponseBody
    public Result getQuestionByQid(@PathVariable Integer qid){
        //system.out.println(qid);
        return questionService.getQuestionByQid(qid);
    }

    @ApiOperation("根据uid查询帖子")
    @ApiImplicitParam(name = "uid" ,value = "用户id",paramType = "path" ,dataType = "int")
    @PostMapping("/getQuestionByUid/{uid}")
    @ResponseBody
    public Result getQuestionByUid(@PathVariable Integer uid){
        //System.out.println(uid);
        return questionService.getQuestionByUid(uid);
    }
    @ApiOperation("搜索帖子/问题")

    @PostMapping("/query")
    @ResponseBody
    public Result queryQuestions(@RequestBody QueryQuestion qQuery){
        return questionService.queryQuestions(qQuery);
    }

    @ApiOperation("点赞/取消点赞")
    @PostMapping("/support/{qId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "flag",value = "点赞还是取消(true:点赞 false:取消点赞)",paramType = "body",dataType = "boolean"),
            @ApiImplicitParam(name = "qId",value = "帖子id",paramType = "path",dataType = "Integer")
    })
    @ResponseBody
    public Result ifSupport(@PathVariable Integer qId,@RequestBody Boolean flag){
        Support.start(qId,flag);
        return R.Ok();
    }
    @ApiOperation("增加浏览量")
    @PostMapping("/scan/{qId}")
    @ApiImplicitParam(name = "qId",value = "帖子id",paramType = "path",dataType = "Integer")
    @ResponseBody
    public Result scan(@PathVariable Integer qId){
        Scan.start(qId);
        return R.Ok();
    }
}
