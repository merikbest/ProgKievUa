package com.gmail.merikbest2015.JavaPRO.lec01.reflection.homework.hw03;

import java.io.*;
import java.lang.reflect.Field;

public class Solution {
    public static void main(String[] args) {
        Test test = new Test("Hello world", 5, 7.7, 8.8);

        Field[] fields = test.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.txt"))) {
                    oos.writeObject(test);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.txt"))) {
            Test test1 = (Test) ois.readObject();
            System.out.println(test1.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}