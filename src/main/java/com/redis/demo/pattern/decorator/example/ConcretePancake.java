package com.redis.demo.pattern.decorator.example;

/**
 * 具体被装饰的对象
 */
public class ConcretePancake implements IPancake {

    @Override
    public void cook() {
        System.out.println("买一个煎饼");
    }
}
