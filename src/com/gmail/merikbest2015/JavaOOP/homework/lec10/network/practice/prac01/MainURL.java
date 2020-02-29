package com.gmail.merikbest2015.JavaOOP.homework.lec10.network.practice.prac01;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainURL {
    public static void main(String[] args) {
        String urlAdress = "https://prog.kiev.ua/forum/index.php";
        String text = getStringFromURL(urlAdress);
        System.out.println(text);
        Map<String,List<String>> result = getHeaderFromURL(urlAdress);
        Set<String> keySet = result.keySet();
        keySet.forEach(key -> System.out.println(key + " - " + result.get(key)));



    }

    public static String getStringFromURL(String urlAdress) {
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(urlAdress);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            //connection.getInputStream() прочитать байтовый поток и с помощью new BufferedReader преобразовать в символьный
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static Map<String, List<String>> getHeaderFromURL(String urlAdress) {
        Map<String, List<String>> result = null;
        try {
            URL url = new URL(urlAdress);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            result = connection.getHeaderFields();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}