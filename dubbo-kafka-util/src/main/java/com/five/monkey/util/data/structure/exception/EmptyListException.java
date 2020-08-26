package com.five.monkey.util.data.structure.exception;

/**
 * 空链表异常
 *
 * @author jim
 * @date 2020/8/26 14:32
 */
public class EmptyListException extends RuntimeException {

    public EmptyListException() {
        super("空链表异常");
    }

}
