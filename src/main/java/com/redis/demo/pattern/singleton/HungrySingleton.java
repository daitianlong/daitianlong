package com.redis.demo.pattern.singleton;

/**
 * 饿汉式单例模式
 */
public class HungrySingleton {

    private static HungrySingleton hungrySingleton;

    private HungrySingleton() {}


    public static  HungrySingleton getInstance() {

        if (hungrySingleton == null) {
            synchronized (HungrySingleton.class){

                if (hungrySingleton == null) {
                    hungrySingleton = new HungrySingleton();
                }
            }
        }
        return hungrySingleton;
    }

}
