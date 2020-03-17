package com.gmail.merikbest2015.JavaPRO.lec01.reflection.homework.hw03;

import java.io.Serializable;

public class Test implements Serializable {
    @Save String string;
    @Save int a;
    @Save double b;
    double c;

    public Test() {
    }

    public Test(String string, int a, double b, double c) {
        this.string = string;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Test{" +
                "string='" + string + '\'' +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}