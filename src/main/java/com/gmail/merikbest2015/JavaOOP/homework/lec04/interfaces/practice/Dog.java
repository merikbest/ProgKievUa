package com.gmail.merikbest2015.JavaOOP.homework.lec04.interfaces.practice;

public class Dog implements Bite {
    private String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean isTasty() {
        return false;
    }

    public void bite(Bite biteThing) {
        if (biteThing == this) {
            System.out.println("I bite myself");
        }
        System.out.println("I bite " + biteThing + " it is " + (biteThing.isTasty() ? "good" : "bad"));
    }


}