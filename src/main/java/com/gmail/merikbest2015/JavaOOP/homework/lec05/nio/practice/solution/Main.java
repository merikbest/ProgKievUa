package com.gmail.merikbest2015.JavaOOP.homework.lec05.nio.practice.solution;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File fileTwo = new File("a.txt");
        try {
            fileTwo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File folder = new File("A");
        folder.mkdirs();

        File fileThree = new File(folder,"b.txt");
        try {
            fileThree.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileThree.delete();
        folder.delete();



        File file = new File(".");
        File[] filesArray = file.listFiles();
        for (File file1 : filesArray) {
            long fileSize = file1.length();
            String type = (file1.isFile()) ? "File" : "Folder";
            System.out.println(file1.getName() + "\t" + type + "\t" + fileSize);
        }
    }
}
