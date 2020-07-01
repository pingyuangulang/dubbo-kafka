package com.five.monkey.wrap.service.impl;

import com.five.monkey.wrap.service.WrapService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * @author jim
 * @date 2020/6/24 21:12
 */
@Slf4j
public class WrapServiceImpl implements WrapService {

    private String before;

    private String after;

    public WrapServiceImpl() {

    }

    public WrapServiceImpl(String before, String after) {
        this.before = before;
        this.after = after;
    }

    @Override
    public String wrap(String word) {
        String msg = "wrap operate prefix=%s,suffix=%s";
        log.info(String.format(msg, before, after));
        return before + word + after;
    }
}
