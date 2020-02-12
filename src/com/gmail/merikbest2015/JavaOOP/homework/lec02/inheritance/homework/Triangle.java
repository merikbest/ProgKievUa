package com.gmail.merikbest2015.JavaOOP.homework.lec02.inheritance.homework;

public class Triangle extends Shape {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private double abSide;
    private double bcSide;
    private double caSide;


    public Triangle(Point point1, Point point2, Point point3) {
        this.pointA = point1;
        this.pointB = point2;
        this.pointC = point3;
    }

    @Override
    double getPerimeter() {
        abSide = Math.sqrt(Math.pow(pointB.getX() - pointA.getX(), 2) + Math.pow(pointB.getY() - pointA.getY(), 2));
        bcSide = Math.sqrt(Math.pow(pointC.getX() - pointB.getX(), 2) + Math.pow(pointC.getY() - pointB.getY(), 2));
        caSide = Math.sqrt(Math.pow(pointC.getX() - pointA.getX(), 2) + Math.pow(pointC.getY() - pointA.getY(), 2));
        return abSide + bcSide + caSide;
    }

    @Override
    double getArea() {
        double perimetr = getPerimeter() / 2.0;
        return Math.sqrt(perimetr * ((perimetr - abSide) *(perimetr - bcSide) * (perimetr - caSide)));
    }
}