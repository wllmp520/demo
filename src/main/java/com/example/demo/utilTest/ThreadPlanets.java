package com.example.demo.utilTest;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: demo
 * @description: 创建要一个不可变且线程安全的类==>final的使用
 * @author: wllmp520
 * @create: 2019-07-03 10:17
 */
public class ThreadPlanets {
    private final Set<String> planets=new TreeSet<>();
    public ThreadPlanets(){
        planets.add("我");
        planets.add("的");
        planets.add("状");
        planets.add("态");
        planets.add("不");
        planets.add("可");
        planets.add("变");
    }
    public boolean isPlanet(String name){
        return  planets.contains(name);
    }
}