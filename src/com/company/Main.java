package com.company;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread threadIncrement = new Thread(new inc());
        Thread threadIncrement2 = new Thread(new inc());
        Thread threadDecrement = new Thread(new dec());
        Thread threadDecrement2 = new Thread(new dec());
        Filter filter = new Filter(4);

        try {
            filter.lock();
            threadIncrement.start();
        } finally {
            System.out.println(counter.getValue());
            filter.unlock();
        }


        try {
            filter.lock();
            threadIncrement2.start();
        } finally {
            System.out.println(counter.getValue());
            filter.unlock();
        }

        try {
            filter.lock();
            threadDecrement.start();
        } finally {
            filter.unlock();
        }


        try {
            filter.lock();
            threadDecrement2.start();
        } finally {
            filter.unlock();
        }


        try {
            threadIncrement.join();
            threadDecrement.join();
            threadIncrement2.join();
            threadDecrement2.join();
            System.out.println("last counter value:  " + counter.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
