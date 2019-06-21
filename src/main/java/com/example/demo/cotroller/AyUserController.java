package com.example.demo.cotroller;

import com.example.demo.exception.BusinessException;
import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: demo
 * @description: 用户控制层
 * @author: wllmp520
 * @create: 2019-06-13 16:46
 */
@Controller
@RequestMapping("/ayUser")
public class AyUserController {
    @Autowired
    private AyUserService ayUserService;

    @RequestMapping("/test")
    public String test(Model model){
        List<AyUser> userList=ayUserService.findAll();
        model.addAttribute("userList",userList);
        return  "ayUser";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<AyUser> userList=ayUserService.findAll();
        model.addAttribute("userList",userList);
        throw new BusinessException("业务异常？？？？");
    }
    @RequestMapping("/testRetry")
    public String testRetry(Model model){
        AyUser userList=ayUserService.findByNameAndPasswordRetry("a","a");
        model.addAttribute("userList",userList);
        return "success";
    }
}