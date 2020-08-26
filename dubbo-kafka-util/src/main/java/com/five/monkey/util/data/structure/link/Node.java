package com.five.monkey.util.data.structure.link;

/**
 * 结点
 *
 * @author jim
 * @date 2020/8/26 11:17
 */
public class Node<E> {

    /** 数据域 */
    private E data;

    /** 后继指针域 */
    private Node<E> next;

    /** 前驱指针域 */
    private Node<E> pre;

    public Node() {
        this(null);
    }

    public Node(E data) {
        this(data, null);
    }

    public Node(E data, Node<E> pre) {
        this(data, null, pre);
    }

    public Node(E data, Node<E> next, Node<E> pre) {
        this.data = data;
        this.next = next;
        this.pre = pre;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPre() {
        return pre;
    }

    public void setPre(Node<E> pre) {
        this.pre = pre;
    }
}
