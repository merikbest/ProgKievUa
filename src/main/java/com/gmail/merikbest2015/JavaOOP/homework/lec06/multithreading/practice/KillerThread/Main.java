package com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.practice.KillerThread;

import com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.practice.factorial.FileWatcher;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File folder = new File(".");
        Thread thread = new Thread(new FileWatcher(folder));
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
