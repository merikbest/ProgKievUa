package com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.practice.DateThread;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new KillerThread());
        thread.start();
    }
}