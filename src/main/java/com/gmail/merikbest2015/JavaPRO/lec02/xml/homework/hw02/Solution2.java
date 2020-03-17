package com.gmail.merikbest2015.JavaPRO.lec02.xml.homework.hw02;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        String path = "src\\com\\gmail\\merikbest2015\\JavaPRO\\lec02\\xml\\homework\\hw02\\json.txt";
        try {
            Gson gson = new GsonBuilder().create();
            Person person = gson.fromJson(new FileReader(path), Person.class);
            System.out.println(person.getName());
            System.out.println(person.getSurname());
            System.out.println(Arrays.toString(person.getPhones()));
            System.out.println(Arrays.toString(person.getSites()));
            System.out.println(person.getAddress().getCity());
            System.out.println(person.getAddress().getCountry());
            System.out.println(person.getAddress().getStreet());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}