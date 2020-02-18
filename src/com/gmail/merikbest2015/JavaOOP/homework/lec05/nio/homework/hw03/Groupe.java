package com.gmail.merikbest2015.JavaOOP.homework.lec05.nio.homework.hw03;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Groupe implements Voenkom {
    private List<Student> students = new ArrayList<Student>(10);

    public Groupe() {
    }

    public void addToFile() {
        try (FileOutputStream fileOut = new FileOutputStream("C:/Users/Miroslav/IdeaProjects/ProgKievUa/src/students.txt");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {
            for (Student student : students) {
                objectOut.writeObject(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:/Users/Miroslav/IdeaProjects/ProgKievUa/src/students.txt"))) {
            for (Student student : students) {
                student = (Student) inputStream.readObject();
                System.out.println(student.getLastName() + " " + student.getFirstName() + " " + student.getAge() + " " + student.getCourse());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        try {
            for (int i = 0; i < 10; i++) {
                students.add(student);
                System.out.println("Студент " + students.get(i).getLastName() + " " + students.get(i).getFirstName() + " добавлен в группу.\n");
                break;
            }

            if (students.size() == 10) {
                throw new StudentExcetion();
            }
        } catch (StudentExcetion e) {
            System.out.println(e);
        }
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) == student) {
                System.out.println("Студент " + students.get(i).getLastName() + " " + students.get(i).getFirstName() + " удален из группы");
                students.remove(student);
                break;
            }
        }
    }

    public void searchStudent(String lastName) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getLastName().equals(lastName)) {
                System.out.println("Студент найден!");
                students.get(i).getInfo();
                break;
            } else {
                System.out.println("Студент не найден!");
                break;
            }
        }
    }

    public void getAllStudents() {
        students.sort(Comparator.comparing(Student::getLastName));
        students.sort(Comparator.comparing(Student::getAge));

        for (Student student : students) {
            student.getInfo();
        }
    }

    public void intercativeAdd() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Введите Фамилию, Имя, возрвст, курс: (Введите exit если закончили)");
                String line = reader.readLine();
                String[] strings = line.split(" ");

                if (line.equals("exit")) {
                    break;
                } else {
                    students.add(new Student(strings[0], strings[1], Integer.parseInt(strings[2]), Integer.parseInt(strings[3])));
                    System.out.println("Студент " + students.get(i).getLastName() + " " + students.get(i).getFirstName() + " добавлен в группу.\n");
                    Arrays.fill(strings, null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getRecruitList() {
        for (Student student : students) {
            if (student.getAge() >= 18) {
                System.out.print("Пригоден к военной службе! ");
                student.getInfo();
            }
        }
    }
}