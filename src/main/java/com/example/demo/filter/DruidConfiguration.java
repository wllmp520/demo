package com.example.demo.filter;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 *@Description: TODO druid的监听类  @Configuration使得该类成为一个配置类相当于 xml ，@Bean相当于bean标签
 *@Param: 
 *@date: 2019/6/12
 */
@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean druidStatViewServle(){
        //ServletRegistrationBean提供类的进行注册
        StatViewServlet a= new StatViewServlet();
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(a,true,"/druid/*");
        //添加初始化参数
        //白名单
        servletRegistrationBean.addInitParameter("allow","127.0.01");
        //黑名单
        servletRegistrationBean.addInitParameter("deny","192.168.1.73");
        //登录查看信息的账号和密码
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        //是否能重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //添加需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
