package com.five.monkey.util.lock;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * @param expire 过期时间,单位:秒
     * @return true:加锁成功
     */
    public boolean lock(String key, String value, @NonNull Long expire) {
        if (StringUtils.isBlank(key)) {
            throw new IllegalArgumentException("class:RedisLock,method:public boolean lock(String key),error message:key is blank");
        }
        Boolean result = stringRedisTemplate.boundValueOps(key).setIfAbsent(value, expire, TimeUnit.SECONDS);
        return Optional.ofNullable(result).orElse(false);
    }

    /**
     * 释放锁
     *
     * @param key 释放锁key
     * @param value 当释放锁value与加锁value相等时才会释放锁
     * @return true:释放锁成功
     */
    public void unLock(String key, String value) {
        String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        RedisScript<Integer> script = new DefaultRedisScript<>(luaScript, Integer.class);
        stringRedisTemplate.execute(script, Stream.of(key).collect(Collectors.toList()), value);

    }
}
