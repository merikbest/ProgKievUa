package com.gmail.merikbest2015.JavaOOP.homework.lec08.genericscollection.homework.hw02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountingCharsImpl implements CountingChars {
    public void getTextCharacters(File file) {
        Map<Character, Integer> unSortedMap = new HashMap<Character, Integer>();
        StringBuilder stringBuilder = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String line = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            char[] alphabetChars = alphabet.toCharArray();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
            String text = stringBuilder.toString().toLowerCase().replaceAll(" ", "");
            char[] textChars = text.toCharArray();
            for (int i = 0; i < alphabetChars.length; i++) {
                char c = alphabetChars[i];
                int count = 0;

                for (int j = 0; j < textChars.length; j++) {
                    if (c == textChars[j])
                        count++;
                }
                if (count != 0) {
                    unSortedMap.put(c, count);
                }
            }
            CountingChars.sortMap(unSortedMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}