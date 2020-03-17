package com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.homework.hw02;

public class SumThread implements Runnable {
    private int[] array;
    private int from;
    private int to;
    private Thread thread;
    private int sum;

    public SumThread(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        sum = 0;
        for (int i = from; i < to; i++) {
            sum += array[i];
        }
    }
}