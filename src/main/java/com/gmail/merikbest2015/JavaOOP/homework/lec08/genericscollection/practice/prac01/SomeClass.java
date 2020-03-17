package com.gmail.merikbest2015.JavaOOP.homework.lec08.genericscollection.practice.prac01;

public class SomeClass <T> {
    private T object;

    public SomeClass(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "object=" + object +
                '}';
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}