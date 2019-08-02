package com.redis.demo.pattern.adapter.example;

/***
 * 背景：小成买了一个进口的电视机
 * 冲突：进口电视机要求电压（110V）与国内插头标准输出电压（220V）不兼容
 * 解决方案：设置一个适配器将插头输出的220V转变成110V
 *
 * 分析:
 *   目标类：进口电视机，需要一个充电头，进口电压为110V，不支持220v
 *   解决方案：需要一个转接头，把220v转成110v电压
 *   适配器：把220v电压转110v
 *   适配者：国内充电器接头220V
 */
public class Example {

    public static void main(String[] args) {

        Target target = new Adpapter();

        target.charge();
    }
}
