package com.gmail.merikbest2015.JavaOOP.homework.lec09.maps.homework.hw03;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"a", "s", "d", "a", "a", "s"};
        Integer[] integers = {1, 2, 3, 4, 1, 2, 3};

        System.out.println(solution.count(strings));
        System.out.println(solution.count(integers));
    }

    public <K> Map<K, Integer> count(K[] array) {
        Map<K, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else
                map.put(array[i], map.get(array[i]) + 1);
        }
        return map;
    }
}