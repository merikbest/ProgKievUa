package com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.practice.DateThread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockThread implements Runnable {
    private SimpleDateFormat sdf;

    public ClockThread() {
        sdf = new SimpleDateFormat("HH:mm:ss");
    }

    public ClockThread(String format) {
        sdf = new SimpleDateFormat(format);
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();

        while (!th.isInterrupted()) {
            System.out.println(sdf.format(new Date()));

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("Clock thread stop");
    }
}