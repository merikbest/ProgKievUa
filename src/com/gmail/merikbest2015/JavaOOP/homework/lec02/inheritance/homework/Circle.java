package com.gmail.merikbest2015.JavaOOP.homework.lec02.inheritance.homework;

public class Circle extends Shape {
    private Point pointA;
    private Point pointB;

    public Circle() {
    }

    public Circle(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * pointA.calcPoint(pointB);
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(pointA.calcPoint(pointB),2);
    }

    public void getInfo() {
        System.out.printf("Периметр круга = %.3f\n" + "Площадь круга = %.3f\n\n", getPerimeter(), getArea());
    }

}
