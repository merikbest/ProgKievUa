package com.gmail.merikbest2015.JavaOOP.homework.lec10.network.practice.prac03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String answer = "";
        Group group = new Group("PN121");
        group.addStudent(new Student("Ivan", "Ivanov", 3));
        group.addStudent(new Student("Petr", "Petrov", 4));
        group.addStudent(new Student("Denis", "Detrov", 5));
        group.addStudent(new Student("Ivan2", "Ivanov2", 1));


        //Генерируем html файл (строку) с данными группы
        answer += "<html<head><title>Student</title><meta charset='utf-8'></head><body><p>Список студентов:"
                + group.getName() + "</p><br>";
        answer += "<table border='2' cellpading='5'><tr><th>Фамилия</th><th>Имя</th><th>Курс</th><th>";
        Student[] starr = group.getGroup();
        for (int i = 0; i < starr.length; i++) {
            answer += "<tr>";
            answer += "<td>" + starr[i].getName() + "</td>";
            answer += "<td>" + starr[i].getLastName() + "</td>";
            answer += "<td>" + starr[i].getCourse() + "</td>";
            answer += "</tr>";
        }
        answer += "</table></body></html>";

        //Создаем серверный сокет и скидываем подключившихся пользователей в новый поток
        try (ServerSocket socket = new ServerSocket(8080)) {
            while (true) {
                Socket clisoc = socket.accept();
                Client cli = new Client(clisoc, answer);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }

    }
}
