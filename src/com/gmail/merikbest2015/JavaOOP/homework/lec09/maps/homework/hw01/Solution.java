package com.gmail.merikbest2015.JavaOOP.homework.lec09.maps.homework.hw01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("world", "мир");
        vocabulary.put("hello", "привет");
        vocabulary.put("java", "ява");

        try (BufferedReader reader = new BufferedReader(new FileReader("a.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("b.txt"))) {
            StringBuilder stringBuilder = new StringBuilder();
            Set<String> keys = vocabulary.keySet();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] strings = line.split(" ");
                for (int i = 0; i < strings.length; i++) {
                    for (String key : keys) {
                        if (strings[i].equals(key)) {
                            stringBuilder.append(vocabulary.get(key) + " ");
                        }
                    }
                }
                writer.write(String.valueOf(stringBuilder));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}