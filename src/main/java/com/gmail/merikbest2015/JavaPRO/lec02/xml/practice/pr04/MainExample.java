package com.gmail.merikbest2015.JavaPRO.lec02.xml.practice.pr04;


import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainExample {
    public static void main(String[] args) throws IOException {
        //Записать
        JsonObject jsonObject = new MainExample().getJson();
        JsonWriter jsonWriterwriter = Json.createWriter(new FileWriter("Student.json"));
        jsonWriterwriter.writeObject(jsonObject);
        jsonWriterwriter.close();

        //Прочитать
        JsonReader jsonReaderreader = Json.createReader(new FileReader("Student.json"));
        JsonObject jsonObject1 = jsonReaderreader.readObject();
        JsonObject student = jsonObject1.getJsonObject("Student");
        System.out.println(student.getString("name"));

    }

    private JsonObject getJson() {
        return Json.createObjectBuilder()
                .add("Student", Json.createObjectBuilder()
                        .add("name", "Max")
                        .add("age", 22)
                        .add("address", Json.createObjectBuilder()
                                .add("city", "Moscov")
                                .add("street", "Lenina")
                        )
                        .add("exams", Json.createArrayBuilder()
                                .add("math")
                                .add("english")
                                .add("chemistry"))
                ).build();
    }
}
