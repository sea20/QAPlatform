package com.service.impl;

import com.bean.Care;
import com.bean.User;
import com.bean.careInformation.QueryCare;
import com.bean.result.Result;
import com.mapper.CareMapper;
import com.mapper.UserMapper;
import com.service.CareService;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Service
public class CareServiceImpl implements CareService {
    @Autowired
    CareMapper careMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public Result select(QueryCare queryCare) {
        Integer current = queryCare.getCurrent();
        Integer limit = queryCare.getLimit();
        queryCare.setCurrent((current - 1)*limit);
        List<Care> list = careMapper.select(queryCare);
        User user = null;
        Integer uId;
        List<User> res = new ArrayList<>();
        if(list != null && list.size() > 0){
            for (Care care : list) {
                if(queryCare.getType() == 1){
                    uId = care.getuId();
                }else {
                    uId = care.getUdId();
                }
                user = userMapper.getPetNameByUId(uId);
                res.add(user);
            }
            return R.Ok().add("data",res);
        }
        return R.Empty();
    }

    @Override
    public Result ifCare(Integer uId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer myUId = user.getId();
        int count = careMapper.ifCare(uId,myUId);
        if(count == 0){
            return R.Empty();
        }
        return R.Ok();
    }

    @Override
    public Result careUser(Integer uId, boolean flag, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer myUId = user.getId();
        if(myUId == uId){
            return R.Error("不能自己关注自己");
        }
        int count = 0;
        if(flag == true){
            count = careMapper.careUser(uId,myUId);
        }else {
            count = careMapper.delCareUser(uId,myUId);
        }
        if(count == 0){
            return R.Error();
        }
        return R.Ok();
    }
}
