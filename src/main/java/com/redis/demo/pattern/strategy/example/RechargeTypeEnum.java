package com.redis.demo.pattern.strategy.example;

public enum RechargeTypeEnum {

    E_BANK_TYPE(1, "网银"),
    MER_ACCOUNT_TYPE(2, "商户账户"),
    MOBILE_TYPE(3, "手机充值"),
    CARD_TYPE(4, "卡充值");

    /**
     * 值
     */
    private int value;

    /**
     * 描述
     */
    private String desc;

    RechargeTypeEnum(int val, String desc) {
        this.value = val;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static RechargeTypeEnum  valueOf(int val) {

        for (RechargeTypeEnum type : RechargeTypeEnum.values()) {

            if (type.value == val) {
                return type;
            }
        }

        return null;
    }
}
