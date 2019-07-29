package com.redis.demo.pattern.strategy.Example;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import javafx.beans.binding.DoubleExpression;

/**
 * 案例
 * 某支付系统接入以下几种商户进行充值：易宝网易，快线网银，19pay手机支付，支付宝支付，
 * 骏网一卡通，由于每家充值系统的结算比例不一样，
 * 而且 同一家商户的不同充值方式也有所不同，具体系统情况比较复杂，
 * 像支付宝既有支付宝账号支付和支付宝网银支付等这些暂时不考虑，
 * 为了讲述策略模式这里简单描 述，假如分为四种，手机支付，网银支付，商户账号支付和点卡支付。
 * 因为没个支付结算比例不同，所以对手续费低的做一些优惠活动，
 * 尽可能让用户使用手续费低 的支付方式来充值，这样降低渠道费用，
 * 增加收入，具体优惠政策如下：
 *
 * 网银充值，8.5折
 * 商户充值，9折
 * 手机充值，没有优惠
 * 点卡充值，收取1%的渠道费
 */
public class Example {

     public static Double  doubleRecharge1(double charge, RechargeTypeEnum  rechargeType){

         if (rechargeType.equals(RechargeTypeEnum.E_BANK_TYPE)) {
             return charge*0.85;
         }

         if (rechargeType.equals(RechargeTypeEnum.MER_ACCOUNT_TYPE)) {
             return charge*0.09;
         }

         if (rechargeType.equals(RechargeTypeEnum.MOBILE_TYPE)) {
             return charge;
         }

         if (rechargeType.equals(RechargeTypeEnum.CARD_TYPE)) {
             return charge*0.01;
         }

         /**
          * 其他返回null
          */

         return null;
     }


    /**
     * 方案2
     * @param charge
     * @param rechargeType
     * @return
     */
    public static Double  doubleRecharge2(double charge, RechargeTypeEnum  rechargeType){

        switch (rechargeType) {
            case E_BANK_TYPE :
                return charge*0.85;
            case CARD_TYPE:
               return charge*0.01;
            case MOBILE_TYPE:
                return charge;
            case MER_ACCOUNT_TYPE:
                return  charge*0.09;

            default:
                return  null;
        }
    }

    public static void main(String[] args) {
        // 方案二
        System.out.println(doubleRecharge2(100,RechargeTypeEnum.E_BANK_TYPE));

        // 方案一
        System.out.println(doubleRecharge1(100,RechargeTypeEnum.E_BANK_TYPE));

        // 优化代码 - 采用设计模式
        Context context = new Context();
        System.out.println(context.calRecharge(100, 1));

    }
}
