package com.redis.demo.redisUtils;

/**
 * redis 接口
 */
public interface RedisService {

    /**
     * set存储数据
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, String value);

    /**
     * 获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置有效时间(s)
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 移除数据
     * @param key
     * @return
     */
    boolean remove(String key);

    /**
     * 判断key是否存在
     * @param key
     * @return true 存在；false 不存在
     */
    boolean  hasKey(String key);

    /**
     * 重命名key
     * @param key
     */
    void  rename(String newKey, String oldKey);

    /**
     * 查询过期时间
     * @param key
     * @return
     */
    Long getExpire(String key);

    //================================Map=================================


}

