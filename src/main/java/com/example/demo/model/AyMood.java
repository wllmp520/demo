package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: demo
 * @description: 微信说说实体
 * @author: wllmp520
 * @create: 2019-06-19 16:49
 */
@Entity
@Table(name = "ay_mood")
@Data
public class AyMood implements Serializable {
    @Id
    private String id;
    private  String content;
    private  String userId;
    private Integer praiseNum;
    private Date publishTime;
}