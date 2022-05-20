package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        t2();
//        Main main = new Main();
//        main.work();
    }

    public class ListPQ<T> {
        public ListPQ(Comparator<T> comparator) {
            this.comparator = comparator;
        }

        List<T> list = new ArrayList<>();

        Comparator<T> comparator;

        public boolean isEmpty(){
            return list.isEmpty();
        }
    }

    public class ListPQ1<T> extends ListPQ<T> {
        public ListPQ1(Comparator<T> comparator) {
            super(comparator);
        }

        public void add(T element) { // addition is fast
            this.list.add(element);
        }

        public T minimum() {
            return this.list.get(0);
        }

        public T removeMinimum() { // removing is time consuming
            return this.list.remove(minIndex());
        }

        private int minIndex() {

            int minIndex = 0;

            T min = this.list.get(0);

            for (int i = 1; i < this.list.size(); i++) {
                T current = this.list.get(i);

                if (this.comparator.compare(current, min) < 0) { // lesser
                    min = current;
                    minIndex = i;
                }
            }

            return minIndex;
        }
    }

    public class ListPQ2<T> extends ListPQ<T> {
        public ListPQ2(Comparator<T> comparator) {
            super(comparator);
        }

        public void add(T element) { // addition is slow -> 2 3 5
            if (!this.isEmpty()) {

                for (int i = 0; i < this.list.size(); i++) { // 1 2 3 5

                    T current = this.list.get(i);

                    if (this.comparator.compare(current, element) > 0) { // equal or greater
                        this.list.add(i, element); // insert at index 3 -> 1 2 3 4 5
                        return;
                    }

                }
            }

            this.list.add(element); // reached list end->insert at end
        }

        public T removeMinimum() { // removing is fast
            return this.list.remove(0);
        }

        public T minimum() {
            return this.list.get(0);
        }
    }


    static List<Ticket> list = new ArrayList<Ticket>();

    public static void t2() {

        list.add(new Ticket("Rashmi", Ticket.SeasonTicket));
        list.add(new Ticket("Jai", Ticket.ClubTicket));
        list.add(new Ticket("Monica", Ticket.OnlineTicket));
        list.add(new Ticket("Chander", Ticket.CounterTicket));
        list.add(new Ticket("Phani", Ticket.SeasonTicket));
        list.add(new Ticket("Rahman", Ticket.CounterTicket));
        for (Ticket a : list) {
            System.out.println("Name: " + a.name +
                    "TicketType: " + a.ticketType);
        }

        System.out.println("");
    }

    void work() {
        PriorityQueue<Ticket> pq = new PriorityQueue<Ticket>(new TicketComparator<Ticket>());
        while (list.isEmpty() == false) {
            pq.add(list.remove(0));
        }
        while (pq.isEmpty() == false) {
            list.add(pq.poll());
        }
        for (Ticket a : list) {
            System.out.println(a);
        }
        System.out.println("");
    }

    public static class Ticket {
        public static final int ClubTicket = 1; // highest priority
        public static final int SeasonTicket = 2;
        public static final int OnlineTicket = 3;
        public static final int CounterTicket = 4; //lowest priority
        public final String name;
        public final int ticketType;

        public Ticket(String name, int ticketType) {
            this.name = name;
            this.ticketType = ticketType;
        }

        public String toString() {
            return this.name;
        }
    }

    class TicketComparator<T extends Ticket> implements Comparator<T> {

        public int compare(T o1, T o2) {
            Ticket a1 = (Ticket) o1;
            Ticket a2 = (Ticket) o2;
            if (a1.ticketType < a2.ticketType) {
                return -1; // lesser
            } else if (a1.ticketType > a2.ticketType) {
                return 1; // greater
            } else if (a1.ticketType == a2.ticketType) {
                return -1;
            } else {
                return 0;
            }
        }

    }

}
