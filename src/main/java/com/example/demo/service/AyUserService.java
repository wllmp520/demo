package com.example.demo.service;

import com.example.demo.model.AyUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @program: demo
 * @description: 用户逻辑
 * @author: wllmp520
 * @create: 2019-06-13 13:37
 */
public interface AyUserService {
    AyUser findById(String id);
    List<AyUser> findAll();
    Future<List<AyUser>> findAsynAll();//异步调用方法
    AyUser save(AyUser ayUser);
    void delete(String id);
    //分页
    Page<AyUser> findAll(Pageable pageable);
    //自定义方法
    //自定义符合JPA规范的方法
    List<AyUser> findByName(String name);

    List<AyUser> findByNameLike(String name);

    List<AyUser> findByIdIn(Collection<String> ids);

    AyUser findByNameAndPassword(@Param("name") String name, @Param("password")String password);
}