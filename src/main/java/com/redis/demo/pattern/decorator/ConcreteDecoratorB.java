package com.redis.demo.pattern.decorator;

public class ConcreteDecoratorB extends  Decorator {

    ConcreteDecoratorB (Component component) {
        super(component);

    }

    @Override
    public void sampleOperation() {
        super.sampleOperation();

        // 写相关的业务代码
        System.out.println("ConcreteDecoratorB");
    }
}
