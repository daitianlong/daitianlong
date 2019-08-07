package com.redis.demo.pattern.proxy;

public class Proxy extends Subject {

    /**
     * 真实的对象
     */
    private  RealSubject realSubject;

    Proxy() {
        getInstance();
    }

    @Override
    void request() {
        System.out.println("Proxy 真是对象做事");
        realSubject.request();
    }

    private   RealSubject getInstance() {

        if (this.realSubject == null) {
            synchronized (this) {
                if (this.realSubject != null){
                    return realSubject;
                }

                if (this.realSubject == null){
                    return realSubject = new RealSubject();
                }
            }
        }
        return realSubject;
    }

}
