package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Filter implements Lock {
    private int[] level;
    private int[] victim;
    private int threadCount;

    public Filter(int n) {
        this.level = new int[n];
        this.victim = new int[n];
        threadCount = n;
        for (int i = 0; i < n; i++) {
            level[i] = 0;
        }
    }

    @Override
    public void lock() {
        int i = (int) (Thread.currentThread().getId() % threadCount);
        System.out.println("thread: " + i);
        for (int L = 1; L < threadCount; L++) {
            level[i] = L;
            victim[L] = i;

            for (int k = 0; k < threadCount; k++) {
                while ((k != i) && (level[k] >= L && victim[L] == i)) {
                }
            }
        }
    }

    @Override
    public void unlock() {
        level[(int)(Thread.currentThread().getId() % threadCount)] = 0;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
