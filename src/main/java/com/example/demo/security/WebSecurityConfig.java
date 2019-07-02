package com.example.demo.security;

import com.example.demo.service.impl.CustomUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @program: demo
 * @description: 安全配置类
 * @author: wllmp520
 * @create: 2019-06-25 15:43
 */
@Configuration
@EnableWebSecurity//开启Security安全框架
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private  CustomUserServiceImpl customUserService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin() //启用默认登录页面
                .failureUrl("/login?error")//登录失败Url
                .defaultSuccessUrl("/ayUser/test")//登录成功跳转页面
                .permitAll();//登录页面获取全部权限
        super.configure(http);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}