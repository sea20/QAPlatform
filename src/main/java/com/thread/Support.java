package com.thread;

import com.bean.result.Result;
import com.service.QuestionService;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class Support {
    @Autowired
    static QuestionService questionService;
    public static LinkedBlockingQueue<Integer> queueAdd = new LinkedBlockingQueue();
    public static LinkedBlockingQueue<Integer> queueDes = new LinkedBlockingQueue();
    static Object lock = new Object();
    static Thread add = new Thread(()->{
        while (true){
            Integer qId = null;
            try {
                qId = queueAdd.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Result res = questionService.support(qId, true);
            if(res.getState() == R.Error().getState()){
                queueAdd.add(qId);
            }
        }
    });
    static Thread des = new Thread(()->{
        while (true){
            Integer qId = null;
            try {
                qId = queueDes.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Result res = questionService.support(qId, false);
            if(res.getState() == R.Error().getState()){
                queueDes.add(qId);
            }
        }
    });
    static {
        add.start();
        des.start();
    }
    public static void start(int qId,boolean flag){
        if(flag) queueAdd.add(qId);
        else queueDes.add(qId);
    }
}
