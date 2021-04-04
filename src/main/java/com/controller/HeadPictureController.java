package com.controller;
import com.bean.HeadPicture;
import com.bean.User;
import com.bean.userInformation.ChangePasswordUser;
import com.bean.userInformation.FindPasswordUser;
import com.bean.userInformation.LoginUser;
import com.bean.result.Result;
import com.email.EmailService;
import com.mapper.HeadPictureMapper;
import com.service.HeadPictureService;
import com.service.UserService;
import com.utils.result.R;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Controller
@Api(tags = "头像Controller")
@RequestMapping("/headPicture")
public class HeadPictureController {

    HeadPictureService headPictureService;
    @Autowired
    public void setHeadPictureService(HeadPictureService headPictureService) {
        this.headPictureService = headPictureService;
    }

    @ApiOperation("更换头像")
    @PostMapping(value = "/change",headers = "content-type=multipart/form-data")
    @ApiImplicitParam(name = "uId",value = "用户id",paramType = "query",dataType = "int")
    @ResponseBody
    public Result uploadHeadPicture(@RequestParam Integer uId,MultipartFile file,HttpServletRequest request){
        return headPictureService.upload(file,uId,request);
    }

    @ApiOperation("获取头像")
    @PostMapping(value = "/getHeadPicture/{uId}")
    @ApiImplicitParam(name = "uId",value = "用户id")
    @ResponseBody
    public Result getHeadPicture(@PathVariable Integer uId){
        return headPictureService.getHeadPicture(uId);
    }
}
