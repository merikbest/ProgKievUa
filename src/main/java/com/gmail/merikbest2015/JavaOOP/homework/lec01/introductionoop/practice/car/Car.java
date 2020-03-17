package com.gmail.merikbest2015.JavaOOP.homework.lec01.introductionoop.practice.car;

public class Car {
    private String colour;
    private double weight;
    private int year;
    private double velosity = 0;

    public Car() {
    }

    public Car(String colour, double weight, int year) {
        this.colour = colour;
        this.weight = weight;
        this.year = year;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getVelosity() {
        return velosity;
    }

    public void beep() {
        System.out.println("beep-beep");
    }

    public void acceleration(double a) {
        velosity = velosity + a;
    }

    public void deceleration(double b) {
        if (velosity - b >= 0) {
            velosity = velosity - b;
        }
    }

//    public void print() {
//        System.out.println("Colour " + colour);
//        System.out.println("Weight " + weight);
//        System.out.println("Year " + year);
//        System.out.println("Velosity " + velosity);
//    }

    @Override
    public String toString() {
        return "Car{" +
                "colour='" + colour + '\'' +
                ", weight=" + weight +
                ", year=" + year +
                ", velosity=" + velosity +
                '}';
    }
}
