package com.redis.demo;

import com.alibaba.fastjson.JSONObject;
import com.redis.demo.entity.Person;
import com.redis.demo.redisUtils.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private  static  final Logger LOGGER = LoggerFactory.getLogger(DemoApplicationTests.class);

    private JSONObject jsonObject = new JSONObject();

    @Autowired
    private RedisService redisService;

    @Test
    public void contextLoads() {
    }

    /**
     * 插入字符串
     */
    @Test
    public void setString() {
        String key = "redis_string_test";
        String value = "springboot redis test";
        boolean result =  redisService.set(key ,value);
        LOGGER.info("redis set key = {},return {}",key,result);
    }

    @Test
    public  void getString () {

        String key = "redis_string_test";
        String result =  redisService.get(key);
        LOGGER.info("-------------------------------------");
        LOGGER.info("redis get key = {},return value =  {}",key,result);
    }


    @Test
    public  void removeKey () {

        String key = "redis_string_test";
        boolean result =  redisService.remove(key);
        LOGGER.info("-------------------------------------");
        LOGGER.info("redis remove key = {},return value =  {}",key,result);
    }

    @Test
    public  void  setObject() {
        String key = "redis_obj_test";
        Person person = new Person("dtl","male");
        LOGGER.info("------------------------------------------------");
        LOGGER.info("person json = {}" , this.jsonObject.toJSONString(person));
        boolean result =  redisService.set(key,this.jsonObject.toJSONString(person));
        LOGGER.info("redis set obj = {},return value =  {}",key,result);
    }

    @Test
    public  void  getObj() {
        String key = "redis_obj_test";
        LOGGER.info("------------------------------------------------");
        String result =  redisService.get(key);
        Person person = JSONObject.parseObject(result,Person.class);
        LOGGER.info("----------------------------------");
        LOGGER.info("person tojson = {}",jsonObject.toJSONString(person));
        LOGGER.info("person name = {}",person.getName());
        LOGGER.info("person sex = {}",person.getSex());
    }

    /**
     * 插入对象List
     */
    @Test
    public void setList() {
        Person person1 = new Person("person1", "male");
        Person person2 = new Person("person2", "female");
        Person person3 = new Person("person3", "male");
        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        redisService.set("redis_list_test", jsonObject.toJSONString(list));
    }

    /**
     * 获取list
     */
    @Test
    public void getList() {
        String result = redisService.get("redis_list_test");
        List<String> list = jsonObject.parseArray(result, String.class);
        System.out.println(list);
    }

    @Test
    public void remove() {
      boolean result =  redisService.remove("redis_test");
       LOGGER.info("-----------------------------------");
       LOGGER.info("redis remove return  =  {}",result);
    }

}
