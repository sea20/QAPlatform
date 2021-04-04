package com.email;

import com.bean.result.Result;
import com.utils.Email.EmailUtils;
import com.utils.result.R;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.GeneralSecurityException;

/**
 * @Auther: Maple
 * @Date: 2021/2/5
 */
@Component
public class EmailService {
    //发送验证码邮件
    public Result sendEmail(String email,String name,HttpSession session){
        String code = Integer.toString((int) ((Math.random()*9+1)*10000));
        session.setAttribute(name,code);
        try {
            EmailUtils.sendEmail(email,code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.Ok();
    }

    //验证
    public boolean testCode(String name,String code, HttpServletRequest request){
        HttpSession session = request.getSession();
        String realCode = (String) session.getAttribute(name);
        if(realCode != null && realCode.equals(code)){
            return true;
        }
        return false;
    }

}
