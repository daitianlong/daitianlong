package com.redis.demo.pattern.strategy;

public class Context   {

    private Strategy strategy;

    Context(Strategy strategy){
        this.strategy = strategy;
    }

    public  void  ContextInterface() {
        strategy.operation();
    }

}
