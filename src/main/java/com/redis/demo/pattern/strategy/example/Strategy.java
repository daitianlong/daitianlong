package com.redis.demo.pattern.strategy.example;

public interface Strategy {

    Double  doubleRecharge(double charge, RechargeTypeEnum  rechargeType);
}
