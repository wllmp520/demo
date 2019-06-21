package com.example.demo.exception;

/**
 * @program: demo
 * @description: 自定义业务异常类
 * @author: wllmp520
 * @create: 2019-06-21 09:20
 */
public class BusinessException extends RuntimeException
{
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}