package com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.practice.DateThread;

public class KillerThread implements Runnable {
    public KillerThread() {

    }

    @Override
    public void run() {
        Thread thread = new Thread(new ClockThread());
        thread.start();
        int a = (int) (Math.random() * 10);
        while (a!=5) {
            System.out.println(a);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = (int) (Math.random() * 10);
        }
        thread.isInterrupted();
        System.out.println("Killer thread stop");
    }
}