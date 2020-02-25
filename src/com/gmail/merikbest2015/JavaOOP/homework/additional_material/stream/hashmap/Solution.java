package com.gmail.merikbest2015.JavaOOP.homework.additional_material.stream.hashmap;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] ints = generateArray(1000000);
//        System.out.println(Arrays.toString(ints));
        Map<Integer, Integer> integerMap = count(ints);
        System.out.println(integerMap);

        Set<Integer> keys = integerMap.keySet();
        for (Integer key : keys) {
            System.out.println(key + " = " + integerMap.get(key) + "\t" + (integerMap.get(key) * 100.0) / ints.length + "%");
        }
    }

    public static int[] generateArray(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    public static Map<Integer, Integer> count(int[] array) {
        Map<Integer, Integer> number = new HashMap<>();
        for (int i : array) {
            Integer element = number.get(i);
            if (element != null) {
                number.put(i, element + 1);
            } else {
                number.put(i, 1);
            }
        }
//        int count = 0;
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < array.length; j++) {
//                if (i == array[j]) {
//                    count++;
//                }
//            }
//            number.put(i, count);
//            count=0;
//        }
        return number;
    }
}