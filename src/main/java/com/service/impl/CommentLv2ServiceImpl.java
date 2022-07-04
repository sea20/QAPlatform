package com.service.impl;

import com.bean.CommentLv2;
import com.bean.User;
import com.bean.result.Result;
import com.mapper.CommentLv1Mapper;
import com.mapper.CommentLv2Mapper;
import com.service.CommentLv2Service;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Service
public class CommentLv2ServiceImpl implements CommentLv2Service {
    @Autowired
    CommentLv2Mapper commentLv2Mapper;
    @Autowired
    CommentLv1Mapper commentLv1Mapper;
    @Override
    public Result selectAllByc1Id(Integer c1Id,Integer uId) {
        List<CommentLv2> list = commentLv2Mapper.selectAllByc1Id(c1Id);
        if(list != null && list.size() > 0){
            if(uId != null){
                Iterator<CommentLv2> iterator = list.iterator();
                while (iterator.hasNext()){
                    if(iterator.next().getUdId() != uId){
                        iterator.remove();
                    }
                }
            }
            return R.Ok().add("data",list);
        }
        return R.Error("没有查到二级评论");
    }

    @Override
    @Transactional
    public Result postCommentLv2(CommentLv2 commentLv2, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        commentLv2.setuId(user.getId());
        int count = commentLv2Mapper.postCommentLv2(commentLv2);
        if(count == 1){
            commentLv1Mapper.addCommentLv1Num(commentLv2.getC1Id());
            return R.Ok();
        }
        return R.Error();
    }
}
