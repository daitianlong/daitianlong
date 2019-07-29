package com.redis.demo.pattern.strategy.Example;


public class MerchStrategy implements  Strategy {


    @Override
    public Double doubleRecharge(double charge, RechargeTypeEnum rechargeType) {

        return charge;
    }
}
