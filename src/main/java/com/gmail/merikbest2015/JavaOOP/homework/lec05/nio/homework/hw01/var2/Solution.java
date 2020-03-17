package com.gmail.merikbest2015.JavaOOP.homework.lec05.nio.homework.hw01.var2;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        File folderIn = new File("C:\\prog\\test");
        File folderOut = new File("C:\\prog\\test2");

        try {
            FileUtils.copyDirectory(folderIn, folderOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}