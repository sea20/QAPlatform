package com.controller;

import com.email.EmailService;
import com.bean.result.Result;
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
 * @Date: 2021/2/5
 */
@Controller
@Api(tags = "邮箱controller")
@RequestMapping("/email")
public class EmailController {
    @Autowired
    EmailService emailService;
    @ApiOperation("获取邮箱验证码")


    @PostMapping("/sendEmail/{name}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email" ,value = "邮箱",paramType = "body"),
            @ApiImplicitParam(name = "name" ,value = "类型",paramType = "path",example = "注册:registerCode 找回密码:findPasswordCode")
    })
    @ResponseBody
    public Result sendEmail(@RequestBody String email, @PathVariable String name, HttpSession session){
        System.out.println(email);
        return emailService.sendEmail(email,name,session);
    }
}
