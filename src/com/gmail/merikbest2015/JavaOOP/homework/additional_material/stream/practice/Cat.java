package com.gmail.merikbest2015.JavaOOP.homework.additional_material.stream.practice;

public class Cat {
    private String name;
    private int age;
    private String colour;

    public Cat(String name, int age, String colour) {
        this.name = name;
        this.age = age;
        this.colour = colour;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", colour='" + colour + '\'' +
                '}';
    }
}