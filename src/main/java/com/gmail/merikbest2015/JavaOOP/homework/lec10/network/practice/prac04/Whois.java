package com.gmail.merikbest2015.JavaOOP.homework.lec10.network.practice.prac04;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois {
    public static void main(String[] args) {
        int c;

        try (Socket socket = new Socket("whois.internic.net", 43);
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            String str = (args.length == 0 ? "OraclePressBook.com" : args[0]) + "\n";
            byte[] bytes = str.getBytes();

            outputStream.write(bytes);

            while ((c = inputStream.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}