package com.redis.demo.pattern.strategy.Example;


public class EBankStrategy implements  Strategy {


    @Override
    public Double doubleRecharge(double charge, RechargeTypeEnum rechargeType) {

        return charge*0.85;
    }
}
