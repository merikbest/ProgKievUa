package com.gmail.merikbest2015.JavaOOP.homework.lec01.introductionoop.level1.hw01;

public class Cat {
    private String name;
    private String colour;
    private int age;
    private double weight;

    public Cat() {
    }

    public Cat(String name, String colour, int age, double weight) {
        this.name = name;
        this.colour = colour;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void meov() {
        System.out.println(name + " Mew-mew");
    }

    public void isFat(double weight) {
        if (weight < 6) {
            System.out.println(weight +" Kg = Normal cat weight");
        } else {
            System.out.println(weight + " Kg = Fat cat");
        }
    }
}
