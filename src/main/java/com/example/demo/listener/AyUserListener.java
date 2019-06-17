package com.example.demo.listener;

import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import com.sun.org.apache.regexp.internal.REDebugCompiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @program: demo
 * @description: 监听器
 * @author: wllmp520
 * @create: 2019-06-14 10:35
 */
@WebListener
public class AyUserListener implements ServletContextListener {
    private static final String ALL="ALL_LIST";

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AyUserService ayUserService;

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized========Redis存储所有用户信息");
        List<AyUser> list=ayUserService.findAll();
        redisTemplate.delete(ALL);
        redisTemplate.opsForList().leftPushAll(ALL,list);
        //测试一下 ，获取数据
        List<AyUser> list1=redisTemplate.opsForList().range(ALL,0,-1);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed=========上下文销毁");
    }
}