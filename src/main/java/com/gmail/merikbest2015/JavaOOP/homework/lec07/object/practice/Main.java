package com.gmail.merikbest2015.JavaOOP.homework.lec07.object.practice;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(3, 4);
        Rectangle rectangle2 = new Rectangle(3, 4);

        System.out.println(rectangle1);

        for (int i = 0; i < 10; i++) {
            new Rectangle(2, 2);
        }

        Rectangle rectangle3 = null;
        try {
            rectangle3 = rectangle2.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println();

        Class classRectangle = rectangle1.getClass();
        Field[] fields = classRectangle.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println();
        Method[] methods = classRectangle.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println();

        Constructor[] constructors = classRectangle.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        //Рефлексия
        try {
            Field w = classRectangle.getDeclaredField("width");
            w.setAccessible(true);
            w.setDouble(rectangle3, 10);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(rectangle3);

        //Сериализация
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("a.txt"))) {
            outputStream.writeObject(rectangle3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Rectangle rectangle5 = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("a.txt"))) {
            rectangle5 = (Rectangle) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(rectangle5 + "+");




        System.out.println(rectangle3.equals(rectangle2));
        System.gc();
        System.out.println("main method stop");
    }
}