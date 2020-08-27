package com.five.monkey.util.data.structure.link;

/**
 * 非线程安全的栈
 *
 * @author jim
 * @date 2020/8/26 15:44
 */
public class Stack<E> {

    private LinkedList<E> list;

    public Stack() {
        this.list = new LinkedList<>();
    }

    public int getSize() {
        return this.list.getSize();
    }

    public void push(E element) {
        this.list.addLast(element);
    }

    public E pop() {
        return this.list.removeLast();
    }

    public boolean isNotEmpty() {
        return this.list.isNotEmpty();
    }
}
