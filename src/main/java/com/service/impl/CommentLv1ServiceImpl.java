package com.service.impl;

import com.bean.CommentLv1;
import com.bean.User;
import com.bean.result.Result;
import com.mapper.CommentLv1Mapper;
import com.service.CommentLv1Service;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Service
public class CommentLv1ServiceImpl implements CommentLv1Service {
    @Autowired
    CommentLv1Mapper commentLv1Mapper;
    @Override
    public Result support(Integer cId) {
        int count = commentLv1Mapper.support(cId);
        if(count == 1){
            return R.Ok();
        }
        return R.Error();
    }

    @Override
    public Result selectAllByPid(Integer qId) {
        List list = commentLv1Mapper.selectAllByPid(qId);
        System.out.println(list);
        if(list != null && list.size()>0){
            return R.Ok().add("data",list);
        }
        return R.Empty();
    }

    @Override
    public Result postCommentLv1(CommentLv1 commentLv1, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        commentLv1.setuId(user.getId());
        int count = commentLv1Mapper.postCommentLv1(commentLv1);
        if(count == 1){
            return R.Ok();
        }
        return R.Error();
    }
}
