package com.example.demo.service.impl;

import com.example.demo.model.AyUserAttachmentRel;
import com.example.demo.repo.AyUserAttachmentRelRepository;
import com.example.demo.service.AyUserAttachmentRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description: 用户附件实现层
 * @author: wllmp520
 * @create: 2019-06-25 15:03
 */
@Service
public class AyUserAttachmentRelServiceImpl implements AyUserAttachmentRelService {
    @Autowired
    private AyUserAttachmentRelRepository ayUserAttachmentRelRepository;
    @Override
    public AyUserAttachmentRel save(AyUserAttachmentRel ayUserAttachmentRel) {
        return ayUserAttachmentRelRepository.save(ayUserAttachmentRel);
    }
}