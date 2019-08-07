package com.redis.demo.pattern.proxy.example;

/**
 * 案例：
 * 常景：小成希望买一台最新的顶配Mac电脑
 * 冲突：国内还没上，只有美国才有
 * 解决方案：寻找代购进行购买
 *
 * 分析：
 * 需要一个目标对象 - 小成
 * 需要做的事-想买一台mac电脑
 *
 *  客观原因：由于小成，各种原因，去不了美国
 *  解决方案：小成需要一个找一个代购，帮忙在美国买一台mac电脑带回国内
 *
 */
public class Example {

    public static void main(String[] args) {

        Subject subject = new Proxy();
        subject.buyMac();
    }
}
