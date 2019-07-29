package com.redis.demo.pattern.strategy.Example;


public class CardBinStrategy implements  Strategy {


    @Override
    public Double doubleRecharge(double charge, RechargeTypeEnum rechargeType) {

        return charge*0.01;
    }
}
