package com.redis.demo.pattern.factory;

public class FactoryB extends  Factory{

    @Override
    Product Manufacture() {
        return new ProductB();
    }
}
