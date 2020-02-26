package com.gmail.merikbest2015.JavaOOP.homework.lec10.network.practice.prac02;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        InetAdressCheck check = new InetAdressCheck();
        File file = new File("site.txt");
        check.loadAdressFromFile(file);
    }
}