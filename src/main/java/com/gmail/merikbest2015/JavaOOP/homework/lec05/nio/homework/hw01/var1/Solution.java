package com.gmail.merikbest2015.JavaOOP.homework.lec05.nio.homework.hw01.var1;

import java.io.File;

public class Solution {
    public static void main(String[] args) {
        MyFileFilter myFileFilter = new MyFileFilter("doc");
        File folder = new File("C:\\prog");

        File[] fileList = folder.listFiles(myFileFilter);
        for (File file : fileList) {
            System.out.println(file);
        }
    }
}