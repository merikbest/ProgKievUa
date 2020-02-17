package com.gmail.merikbest2015.JavaOOP.homework.lec05.nio.homework.hw03;

public class Student extends Human {
    private int course;

    public Student() {
    }

    public Student(String lastName, String firstName, int age, int course) {
        super(lastName, firstName, age);
        this.course = course;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println(" Курс " + course + "\n");
    }
}
