package io.github.zhidao.ms.common.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis 服务层
 * 1、业务系统功能调用
 * 2、屏蔽实现细节
 * 3、自定义封装
 *
 * zhanls 2023/1/19 13:37
 */
@Component
@Lazy
@Slf4j
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean set(String key,String value) {
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e) {
            log.error("redis set error, {} ",e);
            return false;
        }
    }

    public boolean set(String key,String value,long timeout) {
        try {
            this.set(key,value,timeout, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            log.error("redis set error, {} ",e);
            return false;
        }
    }

    public boolean set(String key,String value,long timeout,TimeUnit timeUnit) {
        try {
            redisTemplate.opsForValue().set(key,value,timeout, timeUnit);
            return true;
        } catch (Exception e) {
            log.error("redis set error, {} ",e);
            return false;
        }
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean del(String key) {
        try {
            return redisTemplate.delete(key);
        } catch (Exception e) {
            log.error("redis del error, {} ",e);
            return false;
        }
    }

    public boolean update(String key,String newValue) {
        try {
            redisTemplate.opsForValue().getAndSet(key, newValue);
            return true;
        } catch (Exception e) {
            log.error("redis getAndSet error, {} ",e);
            return false;
        }
    }




}
