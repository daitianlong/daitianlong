package com.redis.demo.pattern.facade.example;

/**
 * 灯类
 */
public class SubSystemA_Light {

    public  void  on(){
        System.out.println("开灯...");
    }

    public  void off() {
        System.out.println("关灯....");
    }

}
