package com.gmail.merikbest2015.JavaOOP.homework.lec03.polymorph.homework;

import java.util.Arrays;
import java.util.Comparator;

public class Groupe {
    private Student[] students = new Student[10];
    private int countStudents = 0;

    public Groupe() {
    }

    public void addStudent(Student student) {
        try {
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = student;
                    System.out.println("Студент " + student.getLastName() + " " + student.getFirstName() + " добавлен в группу.\n");
                    countStudents++;
                    break;
                }

                if (countStudents == students.length)
                    throw new StudentExcetion();
            }
        } catch (StudentExcetion e) {
            System.out.println(e);
        }
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == student) {
                System.out.println("Студент " + student.getLastName() + " " + student.getFirstName() + " удален из группы");
                students[i] = null;
                countStudents--;
                break;
            }
        }
    }

    public void searchStudent(String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getLastName().equals(lastName)) {
                System.out.println("Студент найден!");
                students[i].getInfo();
                break;
            } else {
                System.out.println("Студент не найден!");
                break;
            }
        }
    }

    public void getAllStudents() {
        Arrays.sort(students, Comparator.comparing(Student::getLastName));
        for (Student student : students) {
            student.getInfo();
        }
    }
}