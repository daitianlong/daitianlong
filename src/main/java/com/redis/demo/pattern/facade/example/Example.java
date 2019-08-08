package com.redis.demo.pattern.facade.example;

/**
 * 外观模式
 *
 * 实现客户类与子系统类的松耦合
 * 降低原有系统的复杂度
 * 提高了客户端使用的便捷性，
 * 使得客户端无须关心子系统的工作细节，通过外观角色即可调用相关功能。
 *
 * 定义：
 *
 * 定义了一个高层、统一的接口，外部与通过这个统一的接口对子系统中的一群接口进行访问。
 *
 * 通过创建一个统一的外观类，用来包装子系统中一个 / 多个复杂的类，
 * 客户端可通过调用外观类的方法来调用内部子系统中所有方法
 *
 * 解决问题：
 * 避免了系统与系统之间的高耦合度
 * 使得复杂的子系统用法变得简单
 *
 * 应用场景：
 * 要为一个复杂的子系统对外提供一个简单的接口
 * 提供子系统的独立性
 * 客户程序与多个子系统之间存在很大的依赖性
 *
 * 引入外观类将子系统与客户以及其他子系统解耦，可以提高子系统的独立性和可移植性。
 */
public class Example {

    public static void main(String[] args) {

        /**
         * 背景：小成的爷爷已经80岁了，一个人在家生活：
         * 每次都需要打开灯、打开电视、打开空调；
         * 睡觉时关闭灯、关闭电视、关闭空调；
         * 冲突：行动不方便，走过去关闭那么多电器很麻烦，代码如下：
         */

        /**
         * 未解决情况
         */
        System.out.println("未使用外观模式");
        //早上醒来
        System.out.println("小成早上醒来...");
        SubSystemA_Light light = new SubSystemA_Light();
        SubSystemB_Television television = new SubSystemB_Television();
        SubSystemC_Aircondition aircondition = new SubSystemC_Aircondition();

        light.on();
        television.on();
        aircondition.on();

        System.out.println("小成晚上睡觉...");
        light.off();
        television.off();
        aircondition.off();

        System.out.println("使用外观模式后");

        Facade facade = new Facade(light, television, aircondition);
        System.out.println("小成早上起床...");
        facade.on();
        System.out.println("小成晚上睡觉了...");
        facade.off();
    }
}
