package com.redis.demo.pattern.factory;

public class FactoryA extends Factory {

    @Override
    Product Manufacture() {
        return new ProductA();
    }

}
