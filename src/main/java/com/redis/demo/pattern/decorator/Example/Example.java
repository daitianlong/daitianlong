package com.redis.demo.pattern.decorator.Example;

/**
 * 现在考虑这样一个场景，现在有一个煎饼摊，
 * 人们去买煎饼（Pancake）,有些人要加火腿（Ham）的，
 * 有些人要加鸡蛋（Egg）的，有些人要加生菜（Lettuce）的， letter - 信 ; envelope - 信封
 * 当然土豪可能有啥全给加上^.
 *
 * 分析：
 * 目的是，买一个煎饼，可以任意添加其他辅助吃的
 *
 *  那么，添加调味的食品是动态的，职责是具体被装饰的类
 *
 *  被装饰的类是做一个煎饼，本身职责不变，最终会被动态的添加职责
 *
 *  抽象出一个做煎饼的类，方便为了装饰器扩展
 */
public class Example {

    public static void main(String[] args) {

        // 装饰器对于客户端是透明的，必须知道自己被装饰的对象及动态赋予功能的对象

        // 想买一个煎饼，不添加任何辅助吃的
        // 得到一个煎饼
        //  IPancake iPancake = new ConcretePancake();

        // iPancake.cook();

        // 煎饼加一个鸡蛋

        // IPancake iPancake1 = new EggDecorator(iPancake);
        IPancake iPancake1 = new EggDecorator(new HamDecorator(new LettuceDecorator( new ConcretePancake())));
        iPancake1.cook();
    }
}
