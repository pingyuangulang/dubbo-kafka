package com.five.monkey.provider.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author jim
 * @date 2020/7/20 15:01
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/error/{data}", method = RequestMethod.GET)
    public Map<String, String> errorTest(@PathVariable(value = "data") int data) {
        Map<String, String> map = new HashMap<>();
        if (data >= 10) {
            throw new IllegalArgumentException("参数异常,入参不能大于10");
        } else if (data <= 5) {
            String str = null;
            str.length();
        }
        map.put("result", String.valueOf(data));
        return map;
    }
}
