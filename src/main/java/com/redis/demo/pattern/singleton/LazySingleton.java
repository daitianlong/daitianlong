package com.redis.demo.pattern.singleton;

/**
 * 懒汉式单例模式
 *
 * 缺点：
 * 基础实现的懒汉式是线程不安全的
 *
 * 解决这个线程不安全的，出现饿汉式
 */
public class LazySingleton {

    /**
     *  类加载时，先不自动创建单例
     *  即将单例的引用先赋值为 Null
     */
    private static LazySingleton lazySingleton = null;

    /**
     *   构造函数 设置为 私有权限
     *  原因：禁止他人创建实例
     */
    private  LazySingleton () {

    }

    /**
     * 需要时才手动调用 newInstance（） 创建 单例
     * @return
     */
    public  static  LazySingleton getInstance() {

        // 先判断单例是否为空，以避免重复创建
        if (lazySingleton == null) {
            lazySingleton =  new LazySingleton();
        }

        return lazySingleton;
    }
}
