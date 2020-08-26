package com.five.monkey.util.data.structure.hash;

import java.util.Objects;

/**
 *
 *
 * @author jim
 * @date 2020/8/26 17:09
 */
public class Entry<K, V> {

    private K key;

    private V value;

    private Entry<K, V> next;

    public Entry() {
        this(null);
    }

    public Entry(K key) {
        this(key, null);
    }

    public Entry(K key, V value) {
        this(key, value, null);
    }

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return Objects.nonNull(this.next);
    }

    public Entry<K, V> next() {
        return this.next;
    }
}
