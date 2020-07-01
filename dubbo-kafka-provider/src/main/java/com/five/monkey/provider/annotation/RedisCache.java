package com.five.monkey.provider.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * redis 查询并写入缓存
 *
 * @author jim
 * @date 2020/4/29 22:10
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {

    /**
     * 缓存key
     *
     * @return
     */
    String key();

    /**
     * key有效期时间
     *
     * @return
     */
    long expire() default 0L;

    /**
     * key有效期时间单位
     *
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.HOURS;
}
