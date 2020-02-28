package com.gmail.merikbest2015.JavaOOP.homework.lec10.network.homework.hw02;

public class Solution {
    public static void main(String[] args) {
        String nameOS = "os.name";
        String versionOS = "os.version";
        String architectureOS = "os.arch";

        System.out.println("Name of the OS: " + System.getProperty(nameOS));
        System.out.println("Version of the OS: " + System.getProperty(versionOS));
        System.out.println("Architecture of THe OS: " + System.getProperty(architectureOS));
    }
}
