package com.gmail.merikbest2015.JavaOOP.homework.additional_material.stream.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vasa1", 1, "black");
        Cat cat2 = new Cat("Vasa2", 2, "brown");
        Cat cat3 = new Cat("Vasa3", 3, "grey");
        Cat cat4 = new Cat("Vasa4", 4, "while");
        Cat cat5 = new Cat("Vasa54", 5, "red");

        ArrayList<Cat> catList = new ArrayList<>();
        catList.add(cat1);
        catList.add(cat2);
        catList.add(cat3);
        catList.add(cat4);
        catList.add(cat5);
        printList(catList);

        ArrayList<String> catByAge = catList.stream()
                .filter(n -> n.getAge() > 3)
                .map(n -> n.getName())
                .sorted((a, b) -> a.length() - b.length())
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println();
        printList(catByAge);

    }

    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
