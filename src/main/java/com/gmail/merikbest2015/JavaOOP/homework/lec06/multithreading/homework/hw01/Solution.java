package com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.homework.hw01;

import java.math.BigInteger;

public class Solution implements Runnable {
    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        BigInteger fact = new BigInteger("1");

        for (int i = 1; i < threads.length; i += 1) {
            threads[i] = new Thread();
            fact = fact.multiply(new BigInteger("" + i));
            System.out.println(threads[i].getName() + " " + fact);
        }

        for (int i = 1; i < threads.length; i += 1) {
            threads[i].start();
        }
    }

    @Override
    public void run() {

    }
}