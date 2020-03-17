package com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.practice.synchron;

public class Action {
    private boolean turn;

    public Action() {
    }

    public Action(boolean turn) {
        this.turn = turn;
    }

    public synchronized void getText(String text, boolean turn) {
        while (this.turn == turn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(text + " ");
        this.turn = !this.turn;
        notifyAll();
    }
}