package com.gmail.merikbest2015.JavaOOP.homework.lec08.genericscollection.practice.prac02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(4);
        list.add(10);
        list.add(-2);
        System.out.println(list);

        list.set(2,5);
        System.out.println(list);

        System.out.println(list.lastIndexOf(10));

        list.add(2,18);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }





    }
}