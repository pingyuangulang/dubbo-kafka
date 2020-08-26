package com.five.monkey.util.data.structure.link;

/**
 * 非线程安全的队列
 *
 * @author jim
 * @date 2020/8/26 15:36
 */
public class Queue<E> {

    private LinkedList<E> list;

    public Queue() {
        this.list = new LinkedList<>();
    }

    public int getSize() {
        return this.list.getSize();
    }

    public void push(E element) {
        this.list.addLast(element);
    }

    public E poll() {
        return this.list.removeHead();
    }
}
