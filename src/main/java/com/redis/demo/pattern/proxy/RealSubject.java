package com.redis.demo.pattern.proxy;

public class RealSubject extends  Subject {

    @Override
    void request() {

        System.out.println("RealSubject 做自己的事");
    }
}
