package com.example.demo.threaddemo;

public class ThreadImpl extends Thread  {
    private Thread t;
    private String threadname;
    public ThreadImpl(String threadname) {
        System.out.println("creating "+threadname);
        this.threadname=threadname;
    }

    @Override
    public void run() {
        System.out.println("running "+threadname);
        try {

            for (int i = 0; i <4 ; i++) {
                System.out.println("Thread"+threadname+","+i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println("线程异常");
        }
        System.out.println("Thread"+threadname+"exiting");
    }

    @Override
    public synchronized void start() {
        System.out.println("starting "+threadname);
        if(t==null){
            t=new Thread(this,threadname);
            t.start();
        }
    }
}
