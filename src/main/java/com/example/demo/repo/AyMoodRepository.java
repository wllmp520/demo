package com.example.demo.repo;

import com.example.demo.model.AyMood;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: demo
 * @description: 微信说说Dao
 * @author: wllmp520
 * @create: 2019-06-19 16:53
 */
public interface AyMoodRepository extends JpaRepository<AyMood,String> {
}