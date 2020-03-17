package com.gmail.merikbest2015.JavaOOP.homework.lec04.interfaces.practice;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Bobik");
        Ball ball = new Ball(12, "red");
        Cat cat1 = new Cat("Vaska", 5, "white");
        Cat cat2 = new Cat("Kuza", 2, "white");
        Cat cat3 = new Cat("Murka", 7, "white");
        Cat cat4 = new Cat("Temka", 3, "white");

        Cat[] cats = new Cat[]{cat1, cat2, cat3, cat4};

        for (Cat cat : cats) {
            System.out.println(cat);
        }
        System.out.println();
        Arrays.sort(cats);

        for (Cat cat : cats) {
            System.out.println(cat);
        }
        System.out.println();
        Dog dog1 = new Dog("Belka");

        dog.bite(dog);
        dog.bite(ball);
        dog.bite(cat1);
        dog.bite(dog1);
    }
}
