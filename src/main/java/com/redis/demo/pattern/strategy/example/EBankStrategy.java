package com.redis.demo.pattern.strategy.example;


public class EBankStrategy implements  Strategy {


    @Override
    public Double doubleRecharge(double charge, RechargeTypeEnum rechargeType) {

        return charge*0.85;
    }
}
