package com.gmail.merikbest2015.JavaOOP.homework.lec09.maps.practice;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "one");
        map1.put(5, "five");
        map1.put(2, "two");
        map1.put(3, "three");
        map1.put(4, "four");

        //putIfAbsent
//        map1.putIfAbsent(3, "Three");
//        map1.putIfAbsent(10, "Ten");

        //computeIfAbsent
//        map1.computeIfAbsent(7, key -> "number " + key);
//
//        map1.computeIfPresent(7, (key, value) -> " " + key + " " + value);

        map1.merge(7, "seven", (key, value) -> "number " + value);

        //getOrDefault
        String text = map1.getOrDefault(2, "unknown");
        System.out.println(text);

        //forEach
        map1.forEach((key, value) -> System.out.println(key + " " + value));

        //replaceAll
        map1.replaceAll((key, value) -> value.toUpperCase());
        map1.forEach((key, value) -> System.out.println(key + " " + value));


    }
}
