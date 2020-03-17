package com.gmail.merikbest2015.JavaPRO.lec01.reflection.homework.hw02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {
    public static void main(String[] args) {
        TextContainer container = new TextContainer();
        SaveTo saveTo = container.getClass().getAnnotation(SaveTo.class);
        Method[] methods = container.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                try {
                    method.invoke(container, saveTo.path());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}