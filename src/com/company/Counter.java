package com.company;

class Counter {
    public static int count = 0;


    public Counter() {
    }

    public void increment() {
        count++;
        System.out.println(count);
    }

    public void decrement() {
        count--;
        System.out.println(count);
    }

    public int getValue() {
        return count;
    }
}
