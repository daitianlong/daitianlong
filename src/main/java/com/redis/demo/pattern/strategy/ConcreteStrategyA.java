package com.redis.demo.pattern.strategy;

public class ConcreteStrategyA implements  Strategy {

    @Override
    public void operation() {
        System.out.println("ConcreteStrategyA");
    }
}
