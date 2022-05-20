package com.company;

public class Entry<T> {
    T key;
    int index;

    public Entry(T k, int i) {
        key = k;
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}