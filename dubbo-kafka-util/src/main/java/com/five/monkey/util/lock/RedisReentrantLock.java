package com.five.monkey.util.lock;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Redis分布式锁--可重入锁
 *
 * @author jim
 * @date 2020/9/16 10:13
 */
public class RedisReentrantLock {

    private ThreadLocal<Map<String, Integer>> threadLocal = new ThreadLocal<>();

    private RedisTemplate<String, String> redisTemplate;

    public RedisReentrantLock(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 加锁
     *
     * @param key 加锁key
     * @return true:加锁成功; false:加锁失败
     */
    public boolean lock(String key) {
        boolean lockFlag = false;
        Map<String, Integer> currentLocks = this.currentLocks();
        Integer lockCount = currentLocks.get(key);
        if (Objects.nonNull(lockCount) && lockCount.compareTo(0) > 0) {
            currentLocks.put(key, lockCount + 1);
            lockFlag = true;
        } else if (Optional.ofNullable(redisTemplate.opsForValue().setIfAbsent(key, "", 5, TimeUnit.SECONDS)).orElse(false)) {
            currentLocks.put(key, 1);
            lockFlag = true;
        }
        return lockFlag;
    }

    /**
     * 释放锁
     *
     * @param key 加锁key
     * @return true:释放成功; false:释放失败
     */
    public boolean unLock(String key) {
        boolean unLockFlag = false;
        Map<String, Integer> currentLocks = this.currentLocks();
        Integer lockCount = currentLocks.get(key);
        if (Objects.nonNull(lockCount)) {
            lockCount -= 1;
            if (lockCount.compareTo(0) > 0) {
                currentLocks.put(key, lockCount);
            } else {
                currentLocks.remove(key);
                redisTemplate.delete(key);
            }
            unLockFlag = true;
        }
        return unLockFlag;
    }

    /**
     * 获取当前线程所持有的锁
     *
     * @return
     */
    private Map<String, Integer> currentLocks() {
        Map<String, Integer> map = threadLocal.get();
        if (Objects.isNull(map)) {
            map = new HashMap<>(0);
            threadLocal.set(map);
        }
        return map;
    }
}
