package com.redis.demo.controller;

import com.redis.demo.entity.User;
import com.redis.demo.service.MongoTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongoTestC")
public class MongoTestC {

    private  static  final Logger LOGGER = LoggerFactory.getLogger(MongoTestC.class);

    @Autowired
    private MongoTestService mongoTestService;

    @RequestMapping(value = "save")
    public  void save() {
        User user = new User();
        user.setAge(23);
        user.setName("dtl");

        try {
            mongoTestService.save(user);
        } catch (Exception e) {
            LOGGER.error("mongo test save user exception :  ",e);
        }

    }

}
