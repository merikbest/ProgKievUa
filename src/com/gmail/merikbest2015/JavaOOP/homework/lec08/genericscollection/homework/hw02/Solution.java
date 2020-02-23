package com.gmail.merikbest2015.JavaOOP.homework.lec08.genericscollection.homework.hw02;

import java.io.File;

public class Solution {
    public static void main(String[] args) {
        File file = new File("a.txt");
        CountingCharsImpl countingChars = new CountingCharsImpl();
        countingChars.getTextCharacters(file);
    }
}