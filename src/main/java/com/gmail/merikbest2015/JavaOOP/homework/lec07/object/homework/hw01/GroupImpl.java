package com.gmail.merikbest2015.JavaOOP.homework.lec07.object.homework.hw01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupImpl implements Groupe {
    List<Student> students = new ArrayList<>();

    public GroupImpl() {
    }

    @Override
    public void addStudentsToFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("grope.txt"))) {
            System.out.println("Введите Имя Фамилию Возраст через пробел");
            System.out.println("для завершения пропишыте exit");

//            while ((reader.readLine()) != null) {
            for (int i = 0; i < 10; i++) {
                String line = reader.readLine();
                String[] strings = line.split(" ");
                if (line.equals("exit")) {
                    break;
                } else {
                    students.add(new Student(strings[0], strings[1], Integer.parseInt(strings[2])));
                    Arrays.fill(strings, null);
                }
            }
            for (Student student : students) {
                outputStream.writeObject(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getStudentsFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("grope.txt"))) {
            for (Student student : students) {
                student = (Student) inputStream.readObject();
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getAge());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}