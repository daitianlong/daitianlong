package com.redis.demo.pattern.proxy.example;

/**
 * 真是目标对象
 */
public class RealSubject extends Subject {
    @Override
    void buyMac() {
        System.out.println("小成购买mac电脑");
    }
}
