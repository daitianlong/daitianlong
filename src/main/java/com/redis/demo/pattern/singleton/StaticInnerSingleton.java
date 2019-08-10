package com.redis.demo.pattern.singleton;

/**
 * 静态内部类单例模式
 */
public class StaticInnerSingleton {

    // 1. 创建静态内部类
   private static  class  StaticInnerSingleton2{
       // 在静态内部类里创建单例
        private  static  StaticInnerSingleton staticInnerSingleton = new StaticInnerSingleton();
    }

    // 私有构造函数
    private StaticInnerSingleton() {
    }

    // 延迟加载、按需创建
    public  static  StaticInnerSingleton getInstance() {
        return StaticInnerSingleton2.staticInnerSingleton;
    }

    // 调用过程说明：
    // 1. 外部调用类的newInstance()
    // 2. 自动调用Singleton2.ourInstance
    // 2.1 此时单例类Singleton2得到初始化
    // 2.2 而该类在装载 & 被初始化时，会初始化它的静态域，从而创建单例；
    // 2.3 由于是静态域，因此只会JVM只会加载1遍，Java虚拟机保证了线程安全性
    // 3. 最终只创建1个单例

}
