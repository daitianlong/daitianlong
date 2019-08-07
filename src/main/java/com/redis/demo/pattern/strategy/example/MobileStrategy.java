package com.redis.demo.pattern.strategy.example;


public class MobileStrategy implements  Strategy {


    @Override
    public Double doubleRecharge(double charge, RechargeTypeEnum rechargeType) {

        return charge;
    }
}
