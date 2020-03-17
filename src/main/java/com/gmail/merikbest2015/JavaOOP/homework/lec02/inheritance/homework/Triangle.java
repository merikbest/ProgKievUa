package com.gmail.merikbest2015.JavaOOP.homework.lec02.inheritance.homework;

public class Triangle extends Shape {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle() {
    }

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    @Override
    public double getPerimeter() {
        return pointA.calcPoint(pointB) + pointB.calcPoint(pointC) + pointC.calcPoint(pointA);
    }

    @Override
    public double getArea() {
        double perimetr = getPerimeter() / 2.0;
        return Math.sqrt(perimetr * ((perimetr - pointA.calcPoint(pointB)) * (perimetr - pointB.calcPoint(pointC)) *
                (perimetr - pointC.calcPoint(pointA))));
    }

    public void getInfo() {
        System.out.printf("Периметр треугольника = %.3f\n" + "Площадь треугольника = %.3f\n\n", getPerimeter(), getArea());
    }
}