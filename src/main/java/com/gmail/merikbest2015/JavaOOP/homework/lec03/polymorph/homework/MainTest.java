package com.gmail.merikbest2015.JavaOOP.homework.lec03.polymorph.homework;

import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) {
        Student student1 = new Student( "Иванов", "Иван", 20, 4);
        Student student2 = new Student( "Йванов", "Иван", 20, 4);
        Student student3 = new Student( "Уванов", "Иван", 20, 4);
        Student student4 = new Student( "Кванов", "Иван", 20, 4);
        Student student5 = new Student( "Еванов", "Иван", 20, 4);
        Student student6 = new Student( "Нванов", "Иван", 20, 4);
        Student student7 = new Student( "Гванов", "Иван", 20, 4);
        Student student8 = new Student( "Шванов", "Иван", 20, 4);
        Student student9 = new Student( "Фванов", "Иван", 20, 4);
        Student student10 = new Student( "Ыванов", "Иван", 20, 4);
        Student student11 = new Student( "Вванов", "Иван", 20, 4);

        Groupe groupe = new Groupe();

//        student.getInfo();
//        student1.getInfo();
//        groupe.removeStudent(student1);

        groupe.addStudent(student1);
        groupe.addStudent(student2);
        groupe.addStudent(student3);
        groupe.addStudent(student4);
        groupe.addStudent(student5);
        groupe.addStudent(student6);
        groupe.addStudent(student7);
        groupe.addStudent(student8);
        groupe.addStudent(student9);
        groupe.addStudent(student10);
        groupe.addStudent(student11);

        groupe.searchStudent("Иванов");
        groupe.searchStudent("Иванов2");


        groupe.getAllStudents();








    }
}
