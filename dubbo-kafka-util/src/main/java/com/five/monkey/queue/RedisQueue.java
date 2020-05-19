package com.five.monkey.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 延时队列
 *
 * @author jim
 * @date 2020/5/19 14:14
 */
@Component
public class RedisQueue {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 入队
     *
     * @param key
     * @param value
     * @return
     */
    public boolean push(String key, String value) {
        Long result = stringRedisTemplate.boundListOps(key).leftPush(value);
        result = Optional.ofNullable(result).orElse(0L);
        return result.compareTo(0L) > 0;
    }

    /**
     * 出队
     *
     * @param key
     * @return
     */
    public String pop(String key) {
        return stringRedisTemplate.boundListOps(key).rightPop();
    }
}
