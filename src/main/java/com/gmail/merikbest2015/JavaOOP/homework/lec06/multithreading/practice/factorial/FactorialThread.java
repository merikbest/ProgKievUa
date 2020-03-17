package com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.practice.factorial;

import java.math.BigInteger;

public class FactorialThread implements Runnable {
    private int number;

    public FactorialThread(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private BigInteger calculateFactorial(int number) {
        BigInteger fact = new BigInteger("1");
        for (int i = 2; i <= number; i++) {
            fact = fact.multiply(new BigInteger("" + i));
        }
        return fact;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        for (int i = 0; i <= this.number; i++) {
            System.out.println(thread.getName() + " " + i + "!= " + calculateFactorial(i));
        }


    }
}
