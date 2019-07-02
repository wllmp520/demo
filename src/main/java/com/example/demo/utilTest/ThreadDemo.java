package com.example.demo.utilTest;

import com.example.demo.threaddemo.RunableImpl;

/**
 * @program: demo
 * @description: 1.1.3启动线程
 * @author: wllmp520
 * @create: 2019-06-28 15:19
 */
public class ThreadDemo {
    //1.1.3启动线程
   /* public static void main(String[] args) {
        boolean isDaemon=args.length!=0;
        Runnable r=()->{
          Thread thd=Thread.currentThread();
          while (true){
              System.out.printf("%s is %s alive and in %s state%n",thd.getName(),thd.isAlive()?"":"not",thd.getState());
          }
        };
        Thread t1=new Thread(r,"thd1");
        if(isDaemon) t1.setDaemon(true);
        System.out.printf("%s is %s alive and in %s state%n",t1.getName(),t1.isAlive()?"":"not",t1.getState());

        Thread t2=new Thread(r,"thd2");
        if(isDaemon) t2.setDaemon(true);
        System.out.printf("%s is %s alive and in %s state%n",t2.getName(),t2.isAlive()?"":"not",t2.getState());
        t1.start();
        t2.start();
    }*/
   //1.2线程中断示例
    public static void main(String[] args) {
        Runnable r=()->{
            String name=Thread.currentThread().getName();
            int count=0;
            System.out.println(Thread.currentThread().isInterrupted());
            while (!Thread.interrupted()){
                System.out.println(name+":"+count++);
            }
        };
        Thread thdA=new Thread(r,"我是A");
        Thread thdB=new Thread(r);
        thdA.start();
        thdB.start();
        try {
            Thread.sleep(2000);//当前main 线程睡眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thdA.interrupt();
        thdB.interrupt();
    }
}