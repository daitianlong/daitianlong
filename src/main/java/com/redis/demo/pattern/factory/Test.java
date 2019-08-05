package com.redis.demo.pattern.factory;

public class Test {

    public static void main(String[] args) {
        // 客户A-要生产产品A
        Factory factory = new FactoryA();
        factory.Manufacture().show();


        // 客户B-要生产产品B
        Factory factory1 = new FactoryB();
        factory1.Manufacture().show();

    }
}
