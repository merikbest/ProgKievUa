package com.gmail.merikbest2015.JavaOOP.homework.lec03.polymorph.homework;

public class StudentExcetion extends Exception {
    @Override
    public String getMessage() {
        return "Невозможно добавить студента";
    }
}
