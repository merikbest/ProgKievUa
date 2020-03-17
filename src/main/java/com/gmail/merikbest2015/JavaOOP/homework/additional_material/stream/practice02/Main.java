package com.gmail.merikbest2015.JavaOOP.homework.additional_material.stream.practice02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File file = new File("a.txt");
        printStatistic(file);
    }

    public static void printStatistic(File file) {
        try {
            Files.lines(Paths.get(file.getAbsolutePath()))
                    .map(n -> n.toUpperCase())
                    .flatMapToInt(n -> n.chars())
                    .filter(n -> n >= 'A' && n <= 'Z')
                    .mapToObj((n) -> (Character.valueOf((char) n)))
                    .collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet().stream()
                    .sorted((a, b) -> (int) (b.getValue() - a.getValue()))
                    .forEach(n -> System.out.println(n));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}