package com.example.demo.activemq;

import com.example.demo.model.AyMood;
import com.example.demo.service.AyMoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: 微信说说消费者
 * @author: wllmp520
 * @create: 2019-06-19 17:15
 */
@Component
public class AyMoodConsumer {
    @Autowired
    private AyMoodService ayMoodService;
    @JmsListener(destination = "ayqueue")
    public void recieveQueue(String text){
        //将是对获取信息的处理
        System.out.println("用户发表说说:"+text);
    }
    @JmsListener(destination = "ayqueue.asynsave")
    public void recieveQueue(AyMood ayMood){
        ayMoodService.save(ayMood);
    }
}