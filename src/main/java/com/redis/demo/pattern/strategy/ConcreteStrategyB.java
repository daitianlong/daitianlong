package com.redis.demo.pattern.strategy;

public class ConcreteStrategyB implements  Strategy {

    @Override
    public void operation() {
        System.out.println("ConcreteStrategyB");
    }
}
