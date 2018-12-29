package com.company;

public class inc implements Runnable {
    Counter counter;

    public inc() {
        counter = new Counter();
    }

    public void run() {

        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }

    }
}


