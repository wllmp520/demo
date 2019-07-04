package com.example.demo.utilTest;

/**
 * @program: demo
 * @description: 不同线程关联不同的用户ID
 * @author: wllmp520
 * @create: 2019-07-04 14:17
 */
public class ThreadLocalDemo {
    private static final ThreadLocal<String> userID=new ThreadLocal<String>();

    public static void main(String[] args) {
        Runnable r=new Runnable() {
            @Override
            public void run() {
               String name=Thread.currentThread().getName();
               if(name.equals("A")){
                   userID.set("foxtrot");
               }else{
                   userID.set("charlie");
               }
                System.out.println(name+" "+userID.get());
            }
        };
        Thread thread1=new Thread(r,"A");
        Thread thread2=new Thread(r,"B");
        thread1.start();
        thread2.start();
        System.out.println("main "+ userID.get());
    }
}