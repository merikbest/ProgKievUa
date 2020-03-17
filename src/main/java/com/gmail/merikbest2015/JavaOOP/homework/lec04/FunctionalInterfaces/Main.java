package com.gmail.merikbest2015.JavaOOP.homework.lec04.FunctionalInterfaces;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cat cat1 = new Cat("Vaska", 3);
        Cat cat2 = new Cat("Umka", 7);
        Cat cat3 = new Cat("Kuzia", 5);
        Cat cat4 = new Cat("Dimon", 1);
        Cat cat5 = new Cat("Rigik", 2);

        Cat[] cats = new Cat[]{cat1, null, cat2, null, cat3, cat4, cat5};

        for (Cat cat : cats) {
            System.out.println(cat);
        }

        Arrays.sort(cats, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b) : a.getAge() - b.getAge());

        System.out.println();

        for (Cat cat : cats) {
            System.out.println(cat);
        }
/*        int parametr = 0;
        System.out.println("Input parametr ");

        parametr = scanner.nextInt();

        if (parametr == 1) {
            Arrays.sort(cats, (a, b) -> a.getName().compareTo(b.getName()));
        }

        if (parametr == 2) {
            Arrays.sort(cats, (a, b) -> a.getAge() - b.getAge());
        }

        System.out.println();

        for (Cat cat : cats) {
            System.out.println(cat);
        }*/
    }
}