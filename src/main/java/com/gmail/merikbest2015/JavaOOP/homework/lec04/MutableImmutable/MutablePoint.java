package com.gmail.merikbest2015.JavaOOP.homework.lec04.MutableImmutable;

public class MutablePoint {
    private double x;
    private double y;

    public MutablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Mutable{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
