package com.gmail.merikbest2015.JavaOOP.homework.lec10.network.practice.prac04;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) { //Создаем ServerSocket
            Socket socket = serverSocket.accept(); //Получаем из ServerSocket обычный Socket и ждем пока придет другая программа на порт 8189
            Scanner scanner = new Scanner(socket.getInputStream()); // Для чтения информации (приходит поток данных) "Через сканер"
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true); // Для записи информации(посылаем поток данных) "Через PrintWriter"
//            writer.println("Hello"); //Как только на порт 8189 что-то приходит отдаем запрос "Hello"
//            writer.flush(); //Можно дописать значение true в new PrintWriter(socket.getOutputStream(), true);

            while (scanner.hasNextLine()) { //Работа сервера в цикле до тех пор пока не прийдет exit
                String string = scanner.nextLine();
                writer.println("you have send: " + string);
                System.out.println(string);
                if (string.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}