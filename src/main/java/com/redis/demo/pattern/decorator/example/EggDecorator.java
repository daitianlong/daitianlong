package com.redis.demo.pattern.decorator.example;

public class EggDecorator extends  Decorator {

    EggDecorator(IPancake iPancake) {
        super(iPancake);
    }

    @Override
    public void cook() {
        super.cook();
        // 煎饼加鸡蛋
        System.out.println("加鸡蛋!!!");
    }
}
