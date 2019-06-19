package com.example.demo.service.impl;

import com.example.demo.activemq.AyMoodProducer;
import com.example.demo.model.AyMood;
import com.example.demo.repo.AyMoodRepository;
import com.example.demo.service.AyMoodService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.xml.ws.WebServiceRef;

/**
 * @program: demo
 * @description: 微信说说服务实现层
 * @author: wllmp520
 * @create: 2019-06-19 16:56
 */
@Service
public class AyMoodServiceImpl implements AyMoodService {
    private  static   Destination destination=new ActiveMQQueue("ayqueue.asynsave");
    @Autowired
    private AyMoodProducer ayMoodProducer;

    @Autowired
    private AyMoodRepository ayMoodRepository;

    @Override
    public AyMood save(AyMood ayMood) {
        return ayMoodRepository.save(ayMood);
    }

    @Override
    public String aysncSave(AyMood ayMood) {
        ayMoodProducer.sendMessage(destination,ayMood);
        return "success";
    }
}