package com.redis.demo.pattern.adapter.example;

public class Adpapter extends  Adaptee implements  Target {

    @Override
    public void charge() {
        System.out.println("转换电压...");
        this.changeVoltage();
    }
}
