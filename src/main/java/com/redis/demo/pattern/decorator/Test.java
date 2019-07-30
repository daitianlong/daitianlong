package com.redis.demo.pattern.decorator;

public class Test {

    public static void main(String[] args) {

        ConcreteDecoratorA cd = new ConcreteDecoratorA(new ConcreteCompoent());
        cd.sampleOperation();

    }
}
