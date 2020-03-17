package com.gmail.merikbest2015.JavaOOP.homework.lec08.genericscollection.homework.hw03;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoubleCola {
    private Deque<String> deque = new ArrayDeque<>();

    public Deque<String> getDoubleCola(int n) {
        deque.add("Sheldon");
        deque.add("Leonard");
        deque.add("Volovitc");
        deque.add("Kutrapalli");
        deque.add("Penny");

        for (int i = 0; i < n; i++) {
            deque.addFirst(deque.getFirst());
            deque.addLast(deque.pollFirst());
            deque.addLast(deque.pollFirst());
        }
        return deque;
    }
}