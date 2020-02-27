package com.gmail.merikbest2015.JavaOOP.homework.lec10.network.practice.prac03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {
    private Socket socket;  //Ссылка на клиентский сокет
    private String answer; //Ссылка на строку
    private Thread thread;


    public Client(Socket socket, String answer) {
        this.socket = socket;
        this.answer = answer;
        thread = new Thread(); //Создаем и запускаем новый поток
        thread.start();
    }

    @Override
    public void run() {
        //Получаем входной и выходной поток
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             PrintWriter printWriter = new PrintWriter(outputStream)) {  //Для записи байтов
            //Считуем весь входящий запрос в байтовый масив byte[] rec1
            //inputStream.available() - размер запроса
            byte[] rec1 = new byte[inputStream.available()];

            inputStream.read(rec1); //Считываем запрос

            //Строка ответа
            String response = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n" + "Content-Type: text/html\r\n" +
                    "Content-Length:" + "\r\n" + "Connection: close\r\n\r\n";
            printWriter.print(response + answer);
            printWriter.flush(); //Принудительная финализация потока
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}