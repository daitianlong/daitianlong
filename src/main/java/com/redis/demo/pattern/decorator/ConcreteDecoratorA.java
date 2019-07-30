package com.redis.demo.pattern.decorator;

public class ConcreteDecoratorA extends   Decorator{

    ConcreteDecoratorA(Component component){
        super(component);
    }

    @Override
    public void sampleOperation() {
        super.sampleOperation();

        // 写相关的业务代码
        System.out.println("ConcreteDecoratorA");
    }
}


