package com.gmail.merikbest2015.JavaOOP.homework.lec05.nio.homework.hw02;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("C:\\prog\\first_file.txt");
             FileInputStream fin1 = new FileInputStream("C:\\prog\\op.txt");
             FileInputStream fin2 = new FileInputStream("C:\\prog\\ooop.txt")) {

            int i;

            while ((i = fin1.read()) != -1) {
                fos.write(i);
            }

            while ((i = fin2.read()) != -1) {
                fos.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}