package com.five.monkey.wrap.service.impl;

import com.five.monkey.wrap.service.WrapService;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * @author jim
 * @date 2020/6/24 23:32
 */
@Slf4j
public class DefaultWrapServiceImpl implements WrapService {

    @Override
    public String wrap(String word) {
        log.warn("wrap operate prefix and suffix is blank");
        return word;
    }
}
