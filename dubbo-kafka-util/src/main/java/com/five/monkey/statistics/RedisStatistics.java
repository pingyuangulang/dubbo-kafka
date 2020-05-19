package com.five.monkey.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 统计
 *
 * @author jim
 * @date 2020/5/19 14:40
 */
@Component
public class RedisStatistics {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * page view 统计
     *
     * @param key
     * @return 统计量
     */
    public Long pv(String key) {
        return stringRedisTemplate.boundValueOps(key).increment();
    }

    /**
     * user view 统计
     *
     * @param key
     * @param userInfo user唯一标识
     * @return 统计量
     */
    public Long uv(String key, String userInfo) {
        return stringRedisTemplate.opsForHyperLogLog().add(key, userInfo);
    }

    /**
     * 获取user view统计量
     *
     * @param key
     * @return
     */
    public Long getUvSize(String key) {
        return stringRedisTemplate.opsForHyperLogLog().size(key);
    }
}
