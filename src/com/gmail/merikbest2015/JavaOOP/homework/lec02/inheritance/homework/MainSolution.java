package com.gmail.merikbest2015.JavaOOP.homework.lec02.inheritance.homework;

public class MainSolution {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(new Point(3,33),new Point(33,3),new Point(3,34));
        triangle.getInfo();

        Rectangle rectangle = new Rectangle(new Point(-3,-3),new Point(-3,3),new Point(3,3), new Point(3,-3));
        rectangle.getInfo();

        Circle circle = new Circle(new Point(-3,-3),new Point(3,3));
        circle.getInfo();

        Desc desc = new Desc();
        desc.addShape(triangle,4);
        desc.getShapes(4);
        desc.removeShapes(4);
    }
}