package com.company;

import java.util.Comparator;

public class Main {

    class DefaultComparator<T extends Comparable> implements Comparator<T> {
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
        MyPriorityQueue<Integer> heapifiedPQ = main.insertIntoPQ();

        int value = heapifiedPQ.removeMinimum();
        System.out.println(value);

        value = heapifiedPQ.removeMinimum();
        System.out.println(value);

        value = heapifiedPQ.removeMinimum();
        System.out.println(value);

        value = heapifiedPQ.removeMinimum();
        System.out.println(value);
    }

    private MyPriorityQueue<Integer> insertIntoPQ() {
        MyPriorityQueue<Integer> heapifiedPQ = new Heap<Integer>(new DefaultComparator<Integer>());
        heapifiedPQ.add(300);
        heapifiedPQ.add(500);
        heapifiedPQ.add(100);
        heapifiedPQ.add(400);
        heapifiedPQ.add(200);
        heapifiedPQ.add(600);
        return heapifiedPQ;
    }
}
