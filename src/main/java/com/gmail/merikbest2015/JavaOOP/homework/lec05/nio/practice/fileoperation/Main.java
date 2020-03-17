package com.gmail.merikbest2015.JavaOOP.homework.lec05.nio.practice.fileoperation;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File in = new File("C:\\prog\\import-iava-util-stream-import-java-util-import-java-import-just-to-be-31105806.png");
        File out = new File("java-brain.png");
        System.out.println(FileOperation.calculateFolderSizeTwo(new File("C:/Users/Miroslav/IdeaProjects/ProgKievUa")));

        try {
            FileOperation.fileCopy(in,out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}