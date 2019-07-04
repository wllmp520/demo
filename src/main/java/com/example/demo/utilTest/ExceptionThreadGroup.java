package com.example.demo.utilTest;

/**
 * @program: demo
 * @description: 从run中抛出一个异常
 * @author: wllmp520
 * @create: 2019-07-03 17:14
 */
public class ExceptionThreadGroup {
    public static void main(String[] args) {
        Runnable r=()->{ int x=1/0;};
        Thread t=new Thread(r);
        t.start();
    }
}