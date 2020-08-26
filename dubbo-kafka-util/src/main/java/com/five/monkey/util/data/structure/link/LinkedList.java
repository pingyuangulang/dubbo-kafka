package com.five.monkey.util.data.structure.link;

import com.five.monkey.util.data.structure.exception.EmptyListException;

import java.util.Objects;

/**
 * 非线程安全的链表
 *
 * @author jim
 * @date 2020/8/26 11:26
 */
public class LinkedList<E> {

    /** 链表头结点 */
    private Node<E> head;

    /** 链表尾结点 */
    private Node<E> last;

    /** 链表大小 */
    private int size;

    public LinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * 获取链表长度
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取链表头结点
     *
     * @return
     */
    public Node<E> getHead() {
        return head;
    }

    /**
     * 获取链表尾结点
     *
     * @return
     */
    public Node<E> getLast() {
        return last;
    }

    /**
     * 判断链表是否为空
     *
     * @return true : not empty   false : empty
     */
    public boolean isNotEmpty() {
        return this.size > 0;
    }

    /**
     * 添加元素--尾插法
     *
     * @param element
     */
    public void addLast(E element) {
        Node<E> eNode = new Node<>(element, this.last);
        if (this.isNotEmpty()) {
            this.last.setNext(eNode);
        } else {
            this.head = eNode;
        }
        this.last = eNode;
        this.size++;
    }

    /**
     * 添加元素--头插法
     *
     * @param element
     */
    public void addHead(E element) {
        Node<E> eNode = new Node<>(element, this.head, null);
        if (this.isNotEmpty()) {
            this.head.setPre(eNode);
        } else {
            this.last = eNode;
        }
        this.head = eNode;
        this.size++;
    }

    /**
     * 移除元素--尾移法
     *
     * @return
     */
    public E removeLast() {
        this.checkEmpty();
        Node<E> node = this.last;
        this.last = this.last.getPre();
        this.last.setNext(null);
        node.setPre(null);
        this.size--;
        this.regulate();
        return node.getData();
    }

    /**
     * 移除元素--头移法
     *
     * @return
     */
    public E removeHead() {
        this.checkEmpty();
        Node<E> node = this.head;
        this.head = this.head.getNext();
        this.head.setPre(null);
        node.setNext(null);
        this.size--;
        this.regulate();
        return node.getData();
    }

    /**
     * 清空链表
     *
     * @return
     */
    public boolean removeAll() {
        this.head = null;
        this.last = null;
        this.size = 0;
        return true;
    }

    /**
     * 以head为基准判断是否存在下一个元素
     *
     * @return
     */
    public boolean hasNext() {
        return Objects.nonNull(this.head);
    }

    /**
     * 以head为基准获取下一个元素
     *
     * @return
     */
    public E next() {
        return this.removeHead();
    }

    /**
     * 检查链表为空时抛出空链表异常
     *
     */
    private void checkEmpty() {
        if (!this.isNotEmpty()) {
            throw new EmptyListException();
        }
    }

    /**
     * 当size为0重置head和last
     *
     */
    private void regulate() {
        if (!this.isNotEmpty()) {
            this.head = null;
            this.last = null;
        }
    }
}
