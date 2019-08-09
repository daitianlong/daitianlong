package com.redis.demo.pattern.singleton;

/**
 * 单例模式
 *
 * 优点：
 * 提供了对唯一实例的受控访问；
 * 由于在系统内存中只存在一个对象，
 * 因此可以节约系统资源，对于一些需要频繁创建
 *
 * 和销毁的对象单例模式无疑可以提高系统的性能；
 */
public class Singleton {

    /**
     * 内部进行实例化
     */
    private static Singleton singleton = new Singleton();

    /**
     * 把类的构造方法私有化，
     * 不让外部调用构造方法实例化
     */
    private  Singleton(){

    }

    /**
     * 定义公有方法提供该类的全局唯一访问点
     */
    public  static   Singleton  getInstance() {
        return singleton;
    }

}
