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
@Table(name = "ay_user_role_rel")
public class AyUserRoleRel {
    @Id
    private String userId;
    private  String roleId;
}