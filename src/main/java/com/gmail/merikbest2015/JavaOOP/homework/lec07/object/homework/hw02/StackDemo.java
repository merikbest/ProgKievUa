package com.gmail.merikbest2015.JavaOOP.homework.lec07.object.homework.hw02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackDemo {
    Stack<Object> stack = new Stack<Object>();

    public void addToStack() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = "";

            while (!(line = reader.readLine()).equals("exit")) {
                stack.push(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFromStack() {
        System.out.println(stack.pop());
    }
}