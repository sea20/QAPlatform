package com.thread;

import com.bean.result.Result;
import com.service.QuestionService;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

@Component
public class Scan {
    @Autowired
    static QuestionService questionService;
    public static LinkedBlockingQueue<Integer> queueAdd = new LinkedBlockingQueue();
    static Object lock = new Object();
    static Thread add = new Thread(()->{
        while (true){
            Integer qId = null;
            try {
                qId = queueAdd.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Result res = questionService.scan(qId);
            if(res.getState() == R.Error().getState()){
                queueAdd.add(qId);
            }
        }
    });

    static {
        add.start();
    }
    public static void start(int qId){
        queueAdd.add(qId);
    }
}
