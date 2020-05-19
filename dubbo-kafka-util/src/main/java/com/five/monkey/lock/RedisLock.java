package com.five.monkey.lock;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 *
 * @author jim
 * @date 2020/5/19 13:43
 */
@Component
public class RedisLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 加锁
     *
     * @param key 加锁key
     * @param value 加锁value,释放锁时需要根据value进行判断
     * @param expire
     * @param timeUnit
     * @return true:加锁成功
     */
    public boolean lock(String key, String value, @NonNull Long expire, @NonNull TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            throw new IllegalArgumentException("class:RedisLock,method:public boolean lock(String key),error message:key is blank");
        }
        Boolean result = stringRedisTemplate.boundValueOps(key).setIfAbsent(value, expire, timeUnit);
        return Optional.ofNullable(result).orElse(false);
    }

    /**
     * 释放锁
     *
     * @param key 释放锁key
     * @param value 当释放锁value与加锁value相等时才会释放锁
     * @return true:释放锁成功
     */
    public boolean unLock(String key, String value) {
        Boolean result = false;
        // TODO 此处存在非原子性操作,获取value和删除key不是原子性操作,此处为保证原子性可以使用lua脚本
        if (StringUtils.equals(value, stringRedisTemplate.boundValueOps(key).get())) {
            result = stringRedisTemplate.delete(key);
        }
        return Optional.ofNullable(result).orElse(false);
    }
}
