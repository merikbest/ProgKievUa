package com.gmail.merikbest2015.JavaOOP.homework.lec04.interfaces.homework;

public class StudentExcetion extends Exception {
    @Override
    public String getMessage() {
        return "Невозможно добавить студента";
    }
}
