package com.example.demo.quartz;

import com.example.demo.mail.SendJunkMailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: 发送邮件定时器
 * @author: wllmp520
 * @create: 2019-06-17 16:28
 */
@Component
@Configurable
@EnableScheduling
public class SendMailQuartz {
    @Autowired
    private SendJunkMailService sendJunkMailService;
    private static final Logger logger= LogManager.getLogger(SendMailQuartz.class);

    @Scheduled(cron = "*/5 * * * * *")
    public void sendEmailToHaiS(){
        //sendJunkMailService.sendMail("2320495729@qq.com");
        //sendJunkMailService.sendMail("1413466100@qq.com");
        System.out.println("海生正在接收....");
    }
}