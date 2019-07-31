package com.redis.demo.pattern.decorator.Example;

import javax.swing.*;

/**
 * 装饰类
 */
public class Decorator implements   IPancake {

    /**
     * 为了实现任务委托
     */
    private IPancake iPancake;

    Decorator (IPancake iPancake){
        this.iPancake = iPancake;
    }

    @Override
    public void cook() {
        iPancake.cook();
    }
}
