package com.example.demo.service;

import com.example.demo.model.AyMood;

/**
 * @program: demo
 * @description: 微信说说服务 层
 * @author: wllmp520
 * @create: 2019-06-19 16:55
 */
public interface AyMoodService {
    AyMood save(AyMood ayMood);
    String aysncSave(AyMood ayMood);
}