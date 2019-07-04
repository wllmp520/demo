package com.example.demo.utilTest;

/**
 * @program: demo
 * @description: 将一个对象从父线程传到子线程种
 * @author: wllmp520
 * @create: 2019-07-04 14:51
 */
public class InheritableThreadLocalDemo {
    private static final InheritableThreadLocal<Integer> intVal=new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Runnable r=()->{
            intVal.set(new Integer(10));
            Runnable childR=()->{
                Thread thd=Thread.currentThread();
                String name=thd.getName();
                System.out.printf("%s %d%n",name,intVal.get());
            };
            new Thread(childR,"childR").start();
        };
        new Thread(r,"LIKE ME"). start();
    }
}