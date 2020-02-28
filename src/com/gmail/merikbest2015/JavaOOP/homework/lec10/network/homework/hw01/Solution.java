package com.gmail.merikbest2015.JavaOOP.homework.lec10.network.homework.hw01;

import java.io.File;

public class Solution {
    public static void main(String[] args) {
        InetAdressCheck check = new InetAdressCheck();
        File file = new File("site.txt");
        check.loadAdressFromFile(file);
    }
}