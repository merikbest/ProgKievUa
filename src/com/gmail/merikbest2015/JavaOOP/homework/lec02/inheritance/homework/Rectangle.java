package com.gmail.merikbest2015.JavaOOP.homework.lec02.inheritance.homework;

public class Rectangle extends Shape {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Rectangle() {
    }

    public Rectangle(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    @Override
    public double getPerimeter() {
        return pointA.calcPoint(pointB) + pointB.calcPoint(pointC) + pointC.calcPoint(pointD) + pointD.calcPoint(pointA);
    }

    @Override
    public double getArea() {
        double perimetr = getPerimeter() / 2.0;
        return Math.sqrt(perimetr * ((perimetr - pointA.calcPoint(pointB)) * (perimetr - pointB.calcPoint(pointC)) *
                (perimetr - pointC.calcPoint(pointD)) * (perimetr - pointD.calcPoint(pointA))));
    }

    public void getInfo() {
        System.out.printf("Периметр четырехугольника = %.3f\n" + "Площадь четырехугольника = %.3f\n\n", getPerimeter(), getArea());
    }
}