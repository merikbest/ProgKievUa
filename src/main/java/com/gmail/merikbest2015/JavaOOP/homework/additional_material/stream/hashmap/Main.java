package com.gmail.merikbest2015.JavaOOP.homework.additional_material.stream.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> number = new HashMap<>();
        number.put(1, "one");
        number.put(2, "two");
        number.put(3, "three");
        number.put(4, "four");

        System.out.println(number);
        String value = number.get(5);
        System.out.println(value);
        number.put(5, "five");
        System.out.println(number);

        Set<Integer> set = number.keySet();
        for (Integer key : set) {
            System.out.println(key + " -> " + number.get(key));
        }
    }
}
