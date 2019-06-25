package com.example.demo.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @program: demo
 * @description: 用户头像关联表
 * @author: wllmp520
 * @create: 2019-06-24 17:39
 */
@Data
public class AyUserAttachmentRel implements Serializable {
    @Id
    private String id;
    private String userId;
    private String fileName;
}