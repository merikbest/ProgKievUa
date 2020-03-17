package com.gmail.merikbest2015.JavaOOP.homework.lec06.multithreading.practice.synchron;

public class PullPushThread implements Runnable {
    private String text;
    private Action action;
    private boolean turn;

    public PullPushThread(String text, Action action, boolean turn) {
        this.text = text;
        this.action = action;
        this.turn = turn;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i += 1) {
            action.getText(text, turn);
        }

    }
}
