package com.five.monkey.provider.annotation.handler;

import com.five.monkey.provider.annotation.RedisCache;
import com.five.monkey.provider.annotation.RedisDel;
import com.five.monkey.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 * @author jim
 * @date 2020/4/29 22:20
 */
@Component
@Aspect
public class RedisHandler {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("@annotation(com.five.monkey.provider.annotation.RedisCache)")
    public void cachePointCut() {

    }

    @Pointcut("@annotation(com.five.monkey.provider.annotation.RedisDel)")
    public void delPointCut() {

    }

    /**
     * 查询并加入缓存
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("cachePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Class returnType = methodSignature.getReturnType();
        Object[] args = joinPoint.getArgs();
        RedisCache redisCache = method.getAnnotation(RedisCache.class);
        String key = String.format(redisCache.key(), args);
        long expire = redisCache.expire();
        TimeUnit timeUnit = redisCache.timeUtil();
        String redisValue = stringRedisTemplate.boundValueOps(key).get();
        if (StringUtils.isNotBlank(redisValue)) {
            result = JsonUtil.parse(redisValue, returnType);
        } else {
            result = joinPoint.proceed(args);
            if (Objects.nonNull(result)) {
                redisValue = JsonUtil.toJson(result);
                stringRedisTemplate.boundValueOps(key).set(redisValue, expire, timeUnit);
            }
        }
        return result;
    }

    /**
     * 删除缓存
     *
     * @param joinPoint
     */
    @Before("delPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        RedisDel redisDel = method.getAnnotation(RedisDel.class);
        String[] keys = redisDel.key();
        stringRedisTemplate.delete(Stream.of(keys).collect(Collectors.toList()));
    }
}
