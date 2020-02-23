package com.gmail.merikbest2015.JavaOOP.homework.lec08.genericscollection.homework.hw02;

import java.io.File;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public interface CountingChars {
    void getTextCharacters(File file);

    static void sortMap(Map<Character,Integer> map) {
        LinkedHashMap<Character, Integer> reverseSortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        for (Map.Entry pair : reverseSortedMap.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
    }
}