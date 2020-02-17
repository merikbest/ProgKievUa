package com.gmail.merikbest2015.JavaOOP.homework.lec05.nio.homework.hw03;

public class StudentExcetion extends Exception {
    @Override
    public String getMessage() {
        return "Невозможно добавить студента";
    }
}
