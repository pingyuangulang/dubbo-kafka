package com.five.monkey.util;

import com.alibaba.fastjson.JSON;

/**
 *
 *
 * @author jim
 * @date 2020/4/29 22:40
 */
public class JsonUtil {

    public static String toJson(Object object) {
        return JSON.toJSONString(object);
    }

    public static <T> T parse(String json, Class<T> tClass) {
        return JSON.parseObject(json, tClass);
    }
}
