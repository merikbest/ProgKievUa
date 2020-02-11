package com.gmail.merikbest2015.JavaOOP.homework.lec01.introductionoop.practice.car;

public class DemoCar {
    public static void main(String[] args) {
        Car car = new Car();
        car.setColour("Green");
        car.setWeight(1500);
        car.setYear(1998);
        System.out.println(car);


        System.out.println();
        Car car2 = new Car("Blue", 1200, 2020);
        System.out.println(car2);


    }
}
