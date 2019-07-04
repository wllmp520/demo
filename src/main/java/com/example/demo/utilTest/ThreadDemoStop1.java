package com.example.demo.utilTest;

/**
 * @program: demo
 * @description: 尝试停止一个线程1=-=>volatile的使用
 * @author: wllmp520
 * @create: 2019-07-02 17:51
 */
public class ThreadDemoStop1 {
    public static void main(String[] args) {
         class StoppableThread extends Thread{
             private  boolean isStopped;
             @Override
             public void run() {
                 while (!isStopped) {
                     System.out.println("This is running");
                 }
             }
              void setStopped(){
                 isStopped=true;
             }
         }
         StoppableThread t=new StoppableThread();
         t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.setStopped();
    }

}
