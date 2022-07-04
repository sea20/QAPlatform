package com.service.impl;

import com.bean.CommentLv1;
import com.bean.User;
import com.bean.commentInformation.QueryComment1;
import com.bean.result.Result;
import com.mapper.CommentLv1Mapper;
import com.service.CommentLv1Service;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
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
    public Result selectAllByPid(QueryComment1 queryComment1) {
        Integer uid = queryComment1.getuId();
        Integer current = queryComment1.getCurrent();
        Integer limit = queryComment1.getLimit();
        queryComment1.setCurrent((current-1)*limit);
        List<CommentLv1> list = commentLv1Mapper.selectAllByQueryComment1(queryComment1);
        //System.out.println(list);
        if(list != null && list.size()>0){
            if(uid != null){
                Iterator<CommentLv1> iterator = list.iterator();
                while (iterator.hasNext()){
                    if(iterator.next().getuId() != uid){
                        iterator.remove();
                    }
                }
            }
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
