package com.example.demo.error;

import lombok.Data;

/**
 * @program: demo
 * @description: 自定义异常信息类
 * @author: wllmp520
 * @create: 2019-06-21 09:25
 */
@Data
public class ErrorInfo<T> {
    public static final Integer SUCCESS=200;
    public static final Integer ERROR=100;
    //错误码
    private  Integer code;
    //错误信息
    private  String meassage;
    private  String url;
    private  T data;
}