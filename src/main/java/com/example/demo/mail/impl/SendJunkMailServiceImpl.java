package com.example.demo.mail.impl;

import com.example.demo.mail.SendJunkMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @program: demo
 * @description: 邮件发送服务实现
 * @author: wllmp520
 * @create: 2019-06-17 16:59
 */
@Service
public class SendJunkMailServiceImpl implements SendJunkMailService {

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    private static final Logger logger= LoggerFactory.getLogger(SendJunkMailServiceImpl.class);
    @Override
    public boolean sendMail(String receive) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        try {
            message.setFrom(from);
            message.setSubject("比心心");
            message.setTo(receive);
            message.setText("富士X-A20\n" +
                    "\n" +
                    "不到两千元的价格对于一款微单相机来说还是非常超值的。富士X-A20不仅拥有更好的画质表现，同时在易用性上也值得称道，翻转触控屏幕和USB充电功能都是非常不错的。");
            this.mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("sendMail error receiver=%s",receive,e);
            return false;
        }
        return true;
    }
}