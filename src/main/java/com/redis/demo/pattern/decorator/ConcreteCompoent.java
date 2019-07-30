package com.redis.demo.pattern.decorator;

public class ConcreteCompoent implements  Component {

    @Override
    public void sampleOperation() {
        System.out.println("ConcreteCompoent");
    }
}
