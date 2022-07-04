package com.controller;

import com.bean.User;
import com.bean.userInformation.ChangePasswordUser;
import com.bean.userInformation.FindPasswordUser;
import com.bean.userInformation.LoginUser;
import com.bean.result.Result;
import com.service.UserService;
import com.utils.result.R;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Controller
@Api(tags = "用户Controller")
@RequestMapping("/user")
public class UserController {
                    @Autowired
                    UserService userService;
            @Autowired
            HeadPictureController headPictureController;
            @ApiOperation("注册")
            @ApiImplicitParams(
            {
            @ApiImplicitParam(name = "user" ,value = "用户信息",paramType = "body" ,dataType = "用户信息"),
                    @ApiImplicitParam(name = "code" ,value = "验证码",paramType = "path")
            }
    )
    @PostMapping("/register/{code}")
    @ResponseBody
    public Result changePassword(@RequestBody User user,@PathVariable String code,HttpServletRequest request){
        return userService.register(user,code,request);
    }


    @ApiOperation("登录")
    @ApiImplicitParam(name = "loginUser",paramType = "body",dataType = "登录信息")
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody LoginUser loginUser, HttpServletResponse response){
        return userService.login(loginUser,response);
    }

    @ApiOperation("注销")
    @PostMapping("/cancel")
    @ResponseBody
    public Result cancel(HttpServletRequest request){
        return userService.cancel(request);
    }

    @ApiOperation("修改密码")
    @ApiImplicitParam(name = "cpUser",paramType = "body",dataType = "修改密码信息")
    @PutMapping("/changePassword")
    @ResponseBody
    public Result changePassword(@RequestBody ChangePasswordUser cpUser, HttpServletRequest request){
        return userService.changePassword(cpUser,request);
    }


    @ApiOperation("找回密码")
    @ApiImplicitParam(name = "fpUser",paramType = "body",dataType = "找回密码")
    @PostMapping("/findPassword/{code}")
    @ResponseBody
    public Result findPassword(@RequestBody FindPasswordUser fpUser,@PathVariable String code,HttpServletRequest request){
        return userService.findPassword(fpUser,code,request);
    }

    @ApiOperation("更改昵称")
    @ApiImplicitParam(name = "petName",value = "昵称",paramType = "body")
    @PostMapping("/changePetName")
    @ResponseBody
    public Result findPassword(@RequestBody String petName,HttpServletRequest request){
        return userService.changePetName(petName,request);
    }
    @ApiOperation("根据uId获取用户昵称")
    @GetMapping("/getPetNameByUId/{uId}")
    @ResponseBody
    public Result getPetNameByUId(@PathVariable Integer uId){
        return userService.getPetNameByUId(uId);
    }

    @ApiOperation("获取当前登录用户的信息")
    @GetMapping("/getCurrentUser")
    @ResponseBody
    public Result getCurrentUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        return R.Ok().add("data",user);
    }
}
