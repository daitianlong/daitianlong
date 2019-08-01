package com.redis.demo.pattern.adapter;

/**
 *  适配器
 */
public class Adapter extends Adaptee implements   Target  {

     public void request() {
         System.out.println("Adapter");

         this.specificRequest();
    }
}
