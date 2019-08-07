package com.redis.demo.pattern.decorator.example;

/**
 * 具体给装饰类赋予职责
 */
public class HamDecorator extends  Decorator {

    HamDecorator(IPancake iPancake) {
        super(iPancake);
    }

    @Override
    public void cook() {
        super.cook();

        // 实现煎饼加烤肠的功能
        System.out.println("加烤肠!!");
    }
}
