package com.gmail.merikbest2015.JavaPRO.lec01.reflection.homework.hw02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "file.txt")
public class TextContainer {
    private String string = "Hello world";

    @Saver
    public void save(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}