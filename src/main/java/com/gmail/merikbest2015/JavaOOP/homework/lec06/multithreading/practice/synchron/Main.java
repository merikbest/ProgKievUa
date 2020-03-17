package com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.practice.synchron;

public class Main {
    public static void main(String[] args) {
        Action action = new Action();
        PullPushThread push = new PullPushThread("Push", action, true);
        PullPushThread pull = new PullPushThread("Pull", action, false);

        Thread thread1 = new Thread(push);
        Thread thread2 = new Thread(pull);

        thread1.start();
        thread2.start();
    }
}