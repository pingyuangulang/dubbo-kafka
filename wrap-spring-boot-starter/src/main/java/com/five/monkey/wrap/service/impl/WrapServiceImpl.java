package com.five.monkey.wrap.service.impl;

import com.five.monkey.wrap.service.WrapService;
import lombok.AllArgsConstructor;

/**
 *
 *
 * @author jim
 * @date 2020/6/24 21:12
 */
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
        return before + word + after;
    }
}
