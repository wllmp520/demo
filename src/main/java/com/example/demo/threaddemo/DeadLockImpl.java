package com.example.demo.threaddemo;

//死锁问题
public class DeadLockImpl extends Thread {

    @Override
    public void run() {
        if(this.getName().equals("小果")){
            synchronized ("苹果"){
                System.out.println("小果拿到了水果，并在找刀");
                this.interrupt();
                try{
                    this.wait();
                }catch (InterruptedException e){
                    System.out.println("解锁异常");
                }
                synchronized ("刀"){
                    System.out.println("小果有了水果也有了刀，准备削着吃");
                }
            }
        }else{
            synchronized ("刀"){
                System.out.println("小刀有了刀，要找苹果");
                this.yield();
                synchronized ("苹果"){
                    System.out.println("小刀有了俩个，准");
                }
            }
        }
    }
}
