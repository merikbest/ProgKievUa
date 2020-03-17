package com.gmail.merikbest2015.JavaOOP.homework.lec01.introductionoop.level1.hw01;

public class SolutionCAt {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setAge(7);
        cat.setWeight(10);
        cat.isFat(cat.getWeight());


        Cat cat2 = new Cat("Barsik","Black",5,5);
        cat2.isFat(cat2.getWeight());
        cat2.meov();
    }
}
