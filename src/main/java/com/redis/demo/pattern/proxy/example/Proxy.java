package com.redis.demo.pattern.proxy.example;

/**
 * 代购
 * 需要代购帮忙购买一台mac电脑
 */
public class Proxy extends Subject {
    /**
     * 真正做的其实是目标对象
     */

    private RealSubject realSubject = new RealSubject();

    @Override
    void buyMac() {
        realSubject.buyMac();
        System.out.println("代购做自己的事");
        this.lookLandscape();
    }

    /**
     * 代购自己做的事
     */
    private void lookLandscape(){
        System.out.println("看风景");
    }
}
