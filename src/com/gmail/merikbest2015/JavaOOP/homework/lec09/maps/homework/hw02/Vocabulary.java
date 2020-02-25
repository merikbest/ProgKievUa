package com.gmail.merikbest2015.JavaOOP.homework.lec09.maps.homework.hw02;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Vocabulary {
    Map<String, String> vocabulary = new HashMap<>();

    public void addNewWords() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while (!(line = reader.readLine()).equals("exit")) {
                String[] strings = line.split(" - ");
                vocabulary.put(strings[0], strings[1]);
                Arrays.fill(strings, null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        addToFile(vocabulary);
    }

    private void addToFile(Map<String, String> vocabulary) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("vocabulary.txt"))) {
            objectOutputStream.writeObject(vocabulary);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFromFile() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("vocabulary.txt"))) {
            HashMap<String, String> mapInFile = (HashMap<String, String>) objectInputStream.readObject();
            for (Map.Entry<String, String> m : mapInFile.entrySet()) {
                System.out.println(m.getKey() + " - " + m.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}