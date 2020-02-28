package com.gmail.merikbest2015.JavaOOP.homework.lec10.network.practice.prac04;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class LocalHost {
    public static void main(String[] args) {
        try (Socket socket = new Socket();
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8189)); //ИЛИ "localhost"
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String line;

            while ((line = reader.readLine()) != null) {
                out.write(line + "\n");
                out.flush();
                String serverAnswer = in.readLine();
                System.out.println(serverAnswer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
