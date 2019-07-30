package com.redis.demo.pattern.decorator;

public class Decorator implements  Component {

    private Component component;

    Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void sampleOperation() {
        // 委派给构件
        System.out.println("委派给构件 Decorator");
        component.sampleOperation();
    }
}
