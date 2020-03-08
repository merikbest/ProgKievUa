package com.gmail.merikbest2015.JavaPRO.lec02.xml.homework.hw02;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        try {
            JsonReader jsonReader = Json.createReader(new FileReader("json.txt"));
            JsonObject jsonObject = jsonReader.readObject();

            System.out.println(jsonObject.getString("name"));
            System.out.println(jsonObject.getString("surname"));

            List<JsonValue> phones = jsonObject.getJsonArray("phones");
            for (JsonValue phone : phones) {
                System.out.println(phone.toString());
            }

            List<JsonValue> sites = jsonObject.getJsonArray("sites");
            for (JsonValue site : sites) {
                System.out.println(site.toString());
            }

            JsonObject address = jsonObject.getJsonObject("address");
            System.out.println(address.getString("country"));
            System.out.println(address.getString("city"));
            System.out.println(address.getString("street"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}