package com.example.demo.utilTest;

/**
 * @program: demo
 * @description: 自己写一个线程问题 三个线程: 俩个生产 一个消费, 可能
 * @author: wllmp520
 * @create: 2019-07-03 15:46
 */
public class ThreadGoTest1 {
    public static void main(String[] args) {
        BallFactory b=new BallFactory();
        new Product(b).start();
        new Product2(b).start();
        new Player(b).start();
    }
}
class BallFactory {//球厂
    private String s;
    private volatile boolean isNeed=true;
    synchronized void setBall(String s){
        while (!isNeed){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.s=s;
        System.out.println("生产出了球:"+s);
        isNeed=false;
        notifyAll();
    }
    synchronized String getBall(){
        while (isNeed){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isNeed=true;
        System.out.println("使用了球:"+s);
        notify();
        return s;
    }
}

//生产球
class Product extends Thread{
    private  final BallFactory ball;
    Product(BallFactory ball){
        this.ball=ball;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            ball.setBall("球"+i);
        }
    }
}
class Product2 extends Thread{
    private  final BallFactory ball;
    Product2(BallFactory ball){
        this.ball=ball;
    }

    @Override
    public void run() {
        for (int i = 10; i <20 ; i++) {
            ball.setBall("球"+i);
        }
    }
}
//消费球
class Player extends Thread{
    private  final BallFactory ball;
    Player(BallFactory ball){
        this.ball=ball;
    }

    @Override
    public void run() {
        String s;
        do{
            s = ball.getBall();
        }while (!s.equals("球19"));
    }
}