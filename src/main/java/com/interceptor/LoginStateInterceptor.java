package com.interceptor;

import com.alibaba.druid.support.json.JSONUtils;
import com.bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * @Auther: Maple
 * @Date: 2021/2/5
 */
@Component
//验证登录状态
public class LoginStateInterceptor implements HandlerInterceptor {
    @Autowired
    RedisTemplate redisTemplate;
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                if ("Token".equals(cookie.getName())) {
                    String value = cookie.getValue();
                    Object o = valueOperations.get(value);
                    if (o != null) {
                        HttpSession session = request.getSession();
                        User user = objectMapper.readValue((String) o, User.class);
                        session.setAttribute("user", user);
                        return true;
                    } else {
                        break;
                    }
                }
            }
        }
        /*Cookie cookie = new Cookie("Token", UUID.randomUUID().toString());
        response.addCookie(cookie);*/
        //System.out.println(1);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        objectMapper.writeValue(writer,R.NotLogin());
        return false;
    }
}
