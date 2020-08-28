package com.five.monkey.util.data.structure.exception;

/**
 *
 *
 * @author jim
 * @date 2020/8/27 16:24
 */
public class TreeEmptyException extends RuntimeException {

    public TreeEmptyException() {
        super("空树异常");
    }
}
