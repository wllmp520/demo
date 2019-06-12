package com.example.demo.threaddemo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class RunableImpl implements Runnable {
    private Thread t;
    private String threadName;

    public RunableImpl(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " +  threadName );
    }

    @Override
    public void run() {
        System.out.println("running: "+threadName);
        try{
            for (int i = 0; i < 4; i++) {
                System.out.println("Thread:"+threadName+","+i);
                Thread.sleep(50);
            }
        }catch (Exception e){
            System.out.println("Thread:"+threadName+"is InterruptedException");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
