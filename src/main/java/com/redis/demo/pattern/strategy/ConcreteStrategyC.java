package com.redis.demo.pattern.strategy;

public class ConcreteStrategyC implements  Strategy {

    @Override
    public void operation() {
        System.out.println("ConcreteStrategyC");
    }
}
