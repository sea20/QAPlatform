package com.service.impl;

import com.bean.User;
import com.bean.userInformation.ChangePasswordUser;
import com.bean.userInformation.FindPasswordUser;
import com.bean.userInformation.LoginUser;
import com.bean.result.Result;
import com.email.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapper.HeadPictureMapper;
import com.mapper.UserMapper;
import com.service.UserService;
import com.utils.result.R;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired()
    private UserMapper userMapper;
    EmailService emailService = new EmailService();
    /*@Before
    public void before(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //System.out.println(userMapper);
        SqlSessionTemplate sqlSession = (SqlSessionTemplate) context.getBean("sqlSession");
        userMapper = sqlSession.getMapper(UserMapper.class);
    }*/
    /*@Test
    public void testLogin(){

        LoginUser loginUser = new LoginUser();
        loginUser.setUsername("xusea");
        loginUser.setPassword("123456");
        User user = userMapper.loginUser(loginUser);
        System.out.println(user);
    }*/
    @Override
    public Result login(LoginUser loginUser, HttpServletResponse response) {
        //HttpSession session = request.getSession();
        loginUser.setPassword(DigestUtils.md5DigestAsHex(loginUser.getPassword().getBytes()));
        User user = userMapper.loginUser(loginUser);
        if(user != null ){
            user.setPassword("******");
            //session.setAttribute("user",user);
            String uuid = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("Token",uuid);
            cookie.setPath("/QAPlatform/");
            cookie.setMaxAge(60*60*24*7);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                //缓存登录信息
                redisTemplate.opsForValue().set(uuid,objectMapper.writeValueAsString(user),7, TimeUnit.DAYS);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            response.addCookie(cookie);
            return R.Ok().add("user",user);
        }
        return R.Error("登陆失败");
    }

    /*@Test
    public void testChangePassword(){

        ChangePasswordUser changePasswordUser = new ChangePasswordUser();
        changePasswordUser.setOldPassword("123456");
        changePasswordUser.setNewPassword("a123456a");
        changePasswordUser.setUsername("xusea");
        int i = userMapper.changePassword(changePasswordUser);
        System.out.println(i);
    }*/

    @Override
    public Result changePassword(ChangePasswordUser cpUser, HttpServletRequest request) {
        cpUser.setOldPassword(DigestUtils.md5DigestAsHex(cpUser.getOldPassword().getBytes()));
        cpUser.setNewPassword(DigestUtils.md5DigestAsHex(cpUser.getNewPassword().getBytes()));

        int count = userMapper.changePassword(cpUser);
        if(count == 1){
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            return R.Ok();
        }
        return R.Error();
    }
    /*@Test
    public void testRegistr(){
        User user = new User();
        user.setPassword("a123456a");
        user.setPetName("pet杨帆");
        user.setUsername("yangfan");
        user.setEmail("1193569029@qq.com");

        try {
            int i = userMapper.register(user);
            System.out.println(i);
        }catch (Exception e){

        }
    }*/
    @Override
    public Result register(User user, String code,HttpServletRequest request) {
        if(emailService.testCode("registerCode",code,request)){
            try {
                //密码加密
                user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
                int count = userMapper.register(user);
                if(count != 1){
                    return R.Error("未知错误");
                }
                request.getSession().removeAttribute("registerCode");
                return R.Ok();
            }catch (Exception e){
                System.out.println(e);
                return R.Error("用户名已存在");
            }
        }else {
            return R.Error("验证码错误");
        }
    }
    /*@Test
    public void testRegistr(){
        FindPasswordUser findPasswordUser = new FindPasswordUser();
        findPasswordUser.setUsername("xusea");
        findPasswordUser.setNewPassword("a123456a");
        int password = userMapper.findPassword(findPasswordUser);
        System.out.println(password);
    }*/
    @Override
    public Result findPassword(FindPasswordUser fpUser,String code,HttpServletRequest request) {
        if(emailService.testCode("findPasswordCode",code,request)){
            fpUser.setNewPassword(DigestUtils.md5DigestAsHex(fpUser.getNewPassword().getBytes()));
            int count = userMapper.findPassword(fpUser);
            if(count == 1){
                return R.Ok();
            }else {
                return R.Error("账号不存在");
            }
        }else {
            return R.Error("验证码错误");
        }
    }

    @Override
    public Result changePetName(String petName, HttpServletRequest request) {
        if(petName != null){
            petName = petName.replace("\"","");
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();
        int count = userMapper.changePetName(petName,id);
        if(count == 1){
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if("Token".equals(cookie.getName())){
                    redisTemplate.delete(cookie.getValue());
                }
            }
            return R.Ok();
        }
        return R.Error();
    }

    @Override
    public Result getPetNameByUId(Integer uId) {
        User user = userMapper.getPetNameByUId(uId);
        if(user == null){
            return R.Error();
        }
        return R.Ok().add("data",user);
    }

    @Override
    public Result cancel(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if("Token".equals(cookie.getName())){
                redisTemplate.delete(cookie.getValue());
            }
        }
        return R.Ok();
    }
}
