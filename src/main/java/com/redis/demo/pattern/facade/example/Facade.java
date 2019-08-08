package com.redis.demo.pattern.facade.example;

/**
 * 使用外观模式
* 对外开放外观模式
* 所有对内系统，都必须经过外观模式
* 使得客户端对内变得简单
* 外观模式主要负责转发给子系统
*/

public class Facade {

    private SubSystemA_Light light;

    private SubSystemB_Television television;

    private SubSystemC_Aircondition aircondition;

    public Facade(SubSystemA_Light light, SubSystemB_Television television,
                  SubSystemC_Aircondition aircondition) {
        this.light = light;
        this.television = television;
        this.aircondition = aircondition;
    }

    /**
     * 智能开关 on
     */
    public  void  on() {
        light.on();
        television.on();
        aircondition.on();
    }

    /**
     * 智能开关off
     */
    public  void  off() {
        light.off();
        television.off();
        aircondition.off();
    }

}
