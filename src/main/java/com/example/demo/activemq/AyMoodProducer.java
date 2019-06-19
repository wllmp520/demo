package com.example.demo.activemq;

import com.example.demo.model.AyMood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @program: demo
 * @description: 微信说说生产
 * @author: wllmp520
 * @create: 2019-06-19 17:10
 */
@Service
public class AyMoodProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public  void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
    public  void sendMessage(Destination destination, final AyMood ayMood){
        jmsMessagingTemplate.convertAndSend(destination,ayMood);
    }

}