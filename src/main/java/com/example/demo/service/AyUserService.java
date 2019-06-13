package com.example.demo.service;

import com.example.demo.model.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

/**
 * @program: demo
 * @description: 用户逻辑
 * @author: wllmp520
 * @create: 2019-06-13 13:37
 */
public interface AyUserService {
    AyUser findById(String id);
    List<AyUser> findAll();
    AyUser save(AyUser ayUser);
    void delete(String id);
    //分页
    Page<AyUser> findAll(Pageable pageable);
    //自定义方法
    //自定义符合JPA规范的方法
    List<AyUser> findByName(String name);

    List<AyUser> findByNameLike(String name);

    List<AyUser> findByIdIn(Collection<String> ids);
}