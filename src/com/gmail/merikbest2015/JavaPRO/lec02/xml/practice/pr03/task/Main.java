package com.gmail.merikbest2015.JavaPRO.lec02.xml.practice.pr03.task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws Exception {

        byte[] buf;
        RandomAccessFile f = new RandomAccessFile("json.txt", "r");
        try {
            buf = new byte[(int) f.length()];
            f.read(buf);
        } finally {
            f.close();
        }

        String result = new String(buf);

        Gson gson = new GsonBuilder().create();
        Person person = gson.fromJson(result, Person.class);

        System.out.println(person.name);
        System.out.println(person.address.city);


    }
}
