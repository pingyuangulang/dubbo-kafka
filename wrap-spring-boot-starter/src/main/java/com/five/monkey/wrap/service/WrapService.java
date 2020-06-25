package com.five.monkey.wrap.service;

/**
 *
 *
 * @author jim
 * @date 2020/6/24 21:12
 */
public interface WrapService {

    default String wrap(String word) {
        return word;
    }
}
