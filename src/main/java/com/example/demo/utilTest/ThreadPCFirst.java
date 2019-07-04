package com.example.demo.utilTest;

import org.springframework.security.core.parameters.P;

/**
 *@Description: 生产者消费者问题1 2
 *@Param:
 *@date: 2019/7/3
 */
public class ThreadPCFirst {
    public static void main(String[] args) {
        Shared s=new Shared();
        new Producer(s).start();
        new Consumer(s).start();
    }
}
class  Shared{

    private char c;
    private volatile boolean writeable=true;
    synchronized void setSharedChar(char c)  {
        while (!writeable){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.c=c;
        System.out.println("生产出:" + c);
        writeable=false;
        notify();
    }
    synchronized char getSharedChar()  {
        while (writeable){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writeable=true;
        notify();
        System.out.println("消费:" + c);
        return c;
    }
}
class Producer extends Thread{
    private final Shared s;
    Producer(Shared s){
        this.s=s;
    }

    @Override
    public void run() {
        for (char ch='A';ch<='Z';ch++){

                s.setSharedChar(ch);
                //System.out.println("生产出:" + ch);

        }
    }
}
class Consumer extends Thread{
    private final Shared s;
    Consumer(Shared s){
        this.s=s;
    }

    @Override
    public void run() {
      char ch;
      do{

          ch = s.getSharedChar();
          //System.out.println("消费:" + ch);

      }while (ch!='Z');
    }
}