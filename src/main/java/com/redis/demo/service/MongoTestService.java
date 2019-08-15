package com.redis.demo.service;

import com.redis.demo.entity.User;

public interface MongoTestService {

    /**
     * 保存user
     * @param user
     */
     void save(User user);

    /**
     * 根据name查询user
     * @param name
     * @return
     */
     User  findByName(String name);

    /**
     * 更新用户
     * @param id
     */
    void updateUserById(String  id);

    /**
     * 删除用户
     * @param id
     */
    void deleteById(Integer id);
}
