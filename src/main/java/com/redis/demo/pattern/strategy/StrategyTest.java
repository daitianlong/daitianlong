package com.redis.demo.pattern.strategy;

public class StrategyTest {

    public static void main(String[] args) {

        /**
         *  策略模式：
         *  明确调用类
         *  各类之间互不影响
         */
        Strategy strategy = new ConcreteStrategyA();
        Context context = new Context(strategy);
        context.ContextInterface();

    }

}
