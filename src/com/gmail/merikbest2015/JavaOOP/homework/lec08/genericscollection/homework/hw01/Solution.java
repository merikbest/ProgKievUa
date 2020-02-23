package com.gmail.merikbest2015.JavaOOP.homework.lec08.genericscollection.homework.hw01;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        DeleteElements<Integer> elements = new DeleteElements<Integer>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 10));
        }
        System.out.println(list);
        elements.deleteElements(list);
    }
}