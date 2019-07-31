package com.redis.demo.pattern.decorator.Example;

public class LettuceDecorator extends Decorator {

    LettuceDecorator(IPancake iPancake) {
        super(iPancake);
    }

    @Override
    public void cook() {
        super.cook();

        System.out.println("加生菜!!!");
    }
}
