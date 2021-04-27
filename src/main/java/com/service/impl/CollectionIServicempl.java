package com.service.impl;

import com.bean.Collection;
import com.bean.Question;
import com.bean.User;
import com.bean.collectionInformation.QueryCollection;
import com.bean.result.Result;
import com.mapper.CollectionMapper;
import com.mapper.QuestionMapper;
import com.service.CollectionService;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Service
public class CollectionIServicempl implements CollectionService {

    @Autowired
    CollectionMapper collectionMapper;
    @Autowired
    QuestionMapper questionMapper;
    @Override
    public Result collectionUser(Integer qId, boolean flag, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int count = 0;
        if(flag == true){
             count = collectionMapper.collection(qId,user.getId());
        }else {
            count = collectionMapper.deCollection(qId,user.getId());
        }
        return null;
    }

    @Override
    public Result select(QueryCollection queryCollection) {
        Integer current = queryCollection.getCurrent();
        Integer limit = queryCollection.getLimit();
        queryCollection.setCurrent((current - 1)*limit);
        Integer type = queryCollection.getType();
        List<Collection> list = null;
        switch (type){
            case 1:
                 list = collectionMapper.select(queryCollection);
        }

        Question question = null;
        for (Collection collection : list) {
            question = questionMapper.getQuestionByQid(collection.getqId());
            collection.setQuestion(question);
        }
        if(list != null && list.size() >0){
            return R.Ok().add("data",list);
        }
        return R.Empty();
    }

    @Override
    public Result ifCollection(Integer qId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer uId =user.getId();
        int count = collectionMapper.ifCollection(qId,uId);
        if(count == 0){
            return R.Empty();
        }
        return R.Ok();
    }
}
