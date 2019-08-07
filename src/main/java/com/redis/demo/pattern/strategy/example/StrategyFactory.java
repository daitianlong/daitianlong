package com.redis.demo.pattern.strategy.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略工厂
 */
public class StrategyFactory {

    private static StrategyFactory factory = new StrategyFactory();


    private StrategyFactory (){}

    private static Map<Integer,Strategy> map = new HashMap();

    static {
        map.put(RechargeTypeEnum.E_BANK_TYPE.getValue(), new EBankStrategy());
        map.put(RechargeTypeEnum.MOBILE_TYPE.getValue(), new MobileStrategy());
        map.put(RechargeTypeEnum.CARD_TYPE.getValue(), new CardBinStrategy());
        map.put(RechargeTypeEnum.MER_ACCOUNT_TYPE.getValue(), new MerchStrategy());
    }

    public Strategy creator(Integer type){
        return map.get(type);
    }

    public static  StrategyFactory getFactoryInstance(){
        return  factory;
    }
}
