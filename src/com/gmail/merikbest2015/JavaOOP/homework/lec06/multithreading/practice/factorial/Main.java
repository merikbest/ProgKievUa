package com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.practice.factorial;

public class Main {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new FactorialThread(20));
        Thread threadTwo = new Thread(new FactorialThread(20));
        Thread threadThree = new Thread(new FactorialThread(20));

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName() + " is stop");
    }

}
