package com.gmail.merikbest2015.JavaOOP.homework.lec05.nio.homework.hw02;

import java.io.*;

public class Solution2 {
    public static void main(String[] args) {
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\prog\\first_file.txt"));
             BufferedReader reader1 = new BufferedReader(new FileReader("C:\\prog\\op.txt"));
             BufferedReader reader2 = new BufferedReader(new FileReader("C:\\prog\\ooop.txt"))) {
            String line;

            while ((line = reader1.readLine()) != null) {
                writer1.write(line);
            }

            while ((line = reader2.readLine()) != null) {
                writer1.write(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
