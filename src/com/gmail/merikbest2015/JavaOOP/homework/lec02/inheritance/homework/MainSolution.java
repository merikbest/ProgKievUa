package com.gmail.merikbest2015.JavaOOP.homework.lec02.inheritance.homework;

public class MainSolution {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(new Point(3,33),new Point(33,3),new Point(3,34));
        System.out.printf("%.3f\n", triangle.getPerimeter());
        System.out.printf("%.3f\n", triangle.getArea());


    }
}
