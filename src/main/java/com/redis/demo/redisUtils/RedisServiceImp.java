package com.redis.demo.redisUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * redis 实现类
 */
@Service("redisService")
public class RedisServiceImp implements  RedisService{

   private  static  final Logger LOGGER = LoggerFactory.getLogger(RedisServiceImp.class);

   @Resource
   private RedisTemplate<String,?> redisTemplate;

    @Override
    public boolean set(final String key,final String value) {

           boolean  result = redisTemplate.execute(new RedisCallback<Boolean>() {

            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> redisSerializer =  redisTemplate.getStringSerializer();
                connection.set(redisSerializer.serialize(key), redisSerializer.serialize(value));
                return true;
            }
        });
        return result;
    }

    @Override
    public String get(final String key) {

        String result =  redisTemplate.execute(new  RedisCallback<String>(){

            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {

              RedisSerializer<String> redisSerializer =   redisTemplate.getStringSerializer();
              byte[] value =  connection.get(redisSerializer.serialize(key));
              return  redisSerializer.deserialize(value);
            }
        });
        return result;
    }

    @Override
    public boolean expire(final String key, long expire) {
        return redisTemplate.expire(key,expire, TimeUnit.SECONDS);
    }

    @Override
    public boolean remove(final String key) {

        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {

            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
              RedisSerializer<String> redisSerializer =  redisTemplate.getStringSerializer();
              connection.del(redisSerializer.serialize(key));
                return true;
            }
        });
        return result;
    }

    @Override
    public boolean hasKey(final  String key) {

        try {
            return  this.redisTemplate.hasKey(key);
        } catch (Exception e) {
            LOGGER.error("redis haskey exception :", e);
            return false;
        }
    }

    @Override
    public void rename(String newKey, String oldKey) {

        try {
            this.redisTemplate.rename(oldKey,newKey);
        } catch (Exception e) {
            LOGGER.error("redis rename exception :",e);
        }
    }

    @Override
    public Long getExpire(String key) {

        return  redisTemplate.getExpire(key);
    }
}
