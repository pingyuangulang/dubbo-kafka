package com.five.monkey.util.data.structure.hash;


import java.util.Objects;

/**
 * 非线程安全的哈希表
 *
 * @author jim
 * @date 2020/8/26 17:04
 */
public class HashMap<K, V> {

    /** 键值对集合 */
    private Entry<K, V>[] entries;

    /** 数组大小 */
    private int size;

    /** 总元素数 */
    private int totalElement;

    public HashMap() {
        this(16);
    }

    public HashMap(int initSize) {
        this.entries = new Entry[initSize];
        this.size = initSize;
        this.totalElement = 0;
    }

    /**
     * 添加键值对--头插法
     *
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        this.reSize();
        V oldValue = null;
        Entry<K, V> keyEntry = this.getEntry(key);
        if (Objects.nonNull(keyEntry)) {
            oldValue = keyEntry.setValue(value);
        } else {
            int index = this.index(key);
            Entry<K, V> entry = new Entry<>(key, value, this.entries[index]);
            this.entries[index] = entry;
            this.totalElement++;
        }
        return oldValue;
    }

    /**
     * 根据key获取value
     *
     * @param key
     * @return
     */
    public V get(K key) {
        Entry<K, V> entry = this.getEntry(key);
        return Objects.nonNull(entry) ? entry.getValue() : null;
    }

    /**
     * 删除key
     *
     * @param key
     * @return 返回key对应的value,key不存在时返回null
     */
    public V remove(K key) {
        V value = null;
        int index = this.index(key);
        Entry<K, V> entry = this.entries[index];
        if (Objects.nonNull(entry)) {
            if (entry.getKey().equals(key)) {
                value = entry.getValue();
                this.entries[index] = entry.next();
            } else {
                while (entry.hasNext()) {
                    Entry<K, V> nextEntry = entry.next();
                    if (Objects.isNull(nextEntry) ) {
                        break;
                    }
                    if (nextEntry.getKey().equals(key)) {
                        value = entry.getValue();
                        entry.setNext(nextEntry.next());
                        break;
                    }
                    entry = nextEntry;
                }
            }
        }
        return value;
    }

    /**
     * 判断是否包含key
     *
     * @param key
     * @return true : 包含     false : 不包含
     */
    public boolean containsKey(K key) {
        return Objects.nonNull(this.getEntry(key));
    }

    public boolean isNotEmpty() {
        return this.totalElement > 0;
    }

    /**
     * key的hashCode值对数组大小取余计算对应下标
     *
     * @param key
     * @return
     */
    private int index(K key) {
        return key.hashCode() % this.size;
    }

    /**
     * 扩容--扩容之后的hash表链表使用头插法
     *
     */
    private void reSize() {
        if (this.totalElement < 2 * this.size) {
            return;
        }
        this.size *= 2;
        Entry<K, V>[] kvEntries = new Entry[this.size];
        for (Entry<K, V> oldEntry : this.entries) {
            while (Objects.nonNull(oldEntry)) {
                int index = this.index(oldEntry.getKey());
                Entry<K, V> newEntry = kvEntries[index];
                Entry<K, V> oldEntryNext = oldEntry.next();
                oldEntry.setNext(newEntry);
                kvEntries[index] = oldEntry;
                oldEntry = oldEntryNext;
            }
        }
        this.entries = kvEntries;
    }

    /**
     * 通过key获取entry
     *
     * @param key
     * @return
     */
    private Entry<K, V> getEntry(K key) {
        int index = this.index(key);
        Entry<K, V> entry = this.entries[index];
        Entry<K, V> kvEntry = null;
        while (Objects.nonNull(entry) && entry.hasNext()) {
            entry = entry.next();
            if (entry.getKey().equals(key)) {
                kvEntry = entry;
                break;
            }
        }
        return kvEntry;
    }

}
