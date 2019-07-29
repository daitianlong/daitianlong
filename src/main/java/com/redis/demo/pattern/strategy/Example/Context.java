package com.redis.demo.pattern.strategy.Example;

public class Context {

    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public  Double calRecharge(double charge, Integer type){
       strategy =   StrategyFactory.getFactoryInstance().creator(type);
       return strategy.doubleRecharge(charge,RechargeTypeEnum.valueOf(type));
   }
}
