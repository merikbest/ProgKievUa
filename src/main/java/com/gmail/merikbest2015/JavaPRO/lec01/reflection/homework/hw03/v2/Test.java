package com.gmail.merikbest2015.JavaPRO.lec01.reflection.homework.hw03.v2;

public class Test {
    @Save public int a;
    @Save private String b;
    public long c;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public long getC() {
        return c;
    }

    public void setC(long c) {
        this.c = c;
    }
}
