package com.redis.demo.pattern.proxy;

/**
 * 代理对象的好处是，不想客户端直接跟目标对象接触
 *
 * 术语：
 * 代理对象作为客户端和目标对象之间的中介，起到了保护目标对象的作用
 */
public class Client {
    public static void main(String[] args) {

        Subject subject = new Proxy();
        subject.request();
    }
}
