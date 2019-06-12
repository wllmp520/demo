package com.example.demo.threaddemo;

import java.util.Timer;
import java.util.TimerTask;

public class RunableTest {
   /* public static void main(String[] args) {
        RunableImpl r=new RunableImpl("线程1");
        r.start();
        RunableImpl r2=new RunableImpl("线程2");
        r2.start();
    }*/
  /* public static void main(String[] args) {
       ThreadImpl t=new ThreadImpl("线程1");
       t.start();

       ThreadImpl t2=new ThreadImpl("线程2");
       t2.start();

   }*/
   public static void main(String[] args) {
            DeadLockImpl d=new DeadLockImpl();
            d.setName("小果");

            DeadLockImpl d2=new DeadLockImpl();
            d2.setName("小刀");
            d.start();
            d2.start();
   }
}
