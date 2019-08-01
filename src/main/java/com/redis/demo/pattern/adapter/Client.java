package com.redis.demo.pattern.adapter;

public class Client {

    public static void main(String[] args) {

        /**
         * 分析
         * 适配器目的是为了让两个不相通的类相互联系
         * 客户端使用适配器让目标类能够拥有更多的功能
         */

        Target target = new Adapter();
        target.request();
    }
}
