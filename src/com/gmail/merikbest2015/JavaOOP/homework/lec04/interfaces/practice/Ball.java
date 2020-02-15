package com.gmail.merikbest2015.JavaOOP.homework.lec04.interfaces.practice;

public class Ball implements Bite {
    private int size;
    private String colour;

    public Ball() {
    }

    public Ball(int size, String colour) {
        this.size = size;
        this.colour = colour;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "size=" + size +
                ", colour='" + colour + '\'' +
                '}';
    }

    @Override
    public boolean isTasty() {
        return this.size < 15;
    }
}
