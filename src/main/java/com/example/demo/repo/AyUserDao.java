package com.example.demo.repo;

import com.example.demo.model.AyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AyUserDao {
    AyUser findByNameAndPassword(@Param("name") String name,@Param("password")String password);
}
