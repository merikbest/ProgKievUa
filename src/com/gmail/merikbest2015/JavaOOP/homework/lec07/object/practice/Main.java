package com.gmail.merikbest2015.JavaOOP.homework.lec07.object.practice;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(3, 4);
        Rectangle rectangle2 = new Rectangle(3, 4);

        System.out.println(rectangle1);

        for (int i = 0; i < 10; i++) {
            new Rectangle(2, 2);
        }

        System.gc();

        System.out.println("main method stop");
    }
}