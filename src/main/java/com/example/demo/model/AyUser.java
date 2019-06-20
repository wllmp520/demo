package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *@Description: 用户表实体
 *@Param:
 *@date: 2019/6/13
 */
@Entity
@Table(name = "ay_user")
@Data
public class AyUser implements Serializable {
    @Id
    private String id;
    private String name;
    private String password;

}
