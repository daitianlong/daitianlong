package com.redis.demo.pattern.adapter.example;

/**
 * 目标类
 * 进口电视机，需要充电,需要一个220v转接头
 */
public interface Target {
    /**
     * 充电
     */
    void charge();
}
