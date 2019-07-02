package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: demo
 * @description: 角色类
 * @author: wllmp520
 * @create: 2019-06-25 16:16
 */
@Entity
@Data
@Table(name = "ay_role")
public class AyRole {
    @Id
    private String id;
    private  String name;
}