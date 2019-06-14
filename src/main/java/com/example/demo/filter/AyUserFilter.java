package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: demo
 * @description: 过滤器
 * @author: wllmp520
 * @create: 2019-06-14 09:55
 */
@WebFilter(filterName = "ayUserFilter",urlPatterns = "/*")
public class AyUserFilter implements Filter {
    //初始化参数
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=================init");
    }

    //执行
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("================doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    //销毁
    @Override
    public void destroy() {
        System.out.println("=================destroy");
    }
}