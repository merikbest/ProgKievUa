package com.gmail.merikbest2015.JavaOOP.homework.lec10.network.practice.prac02;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class InetAdressCheck {
    private Set<String> stringSet = new HashSet<>();

    public InetAdressCheck() {
    }

    public void loadAdressFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                stringSet.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        checkURL();
    }

    private void checkURL() {
        for (String site : stringSet) {
            try {
                URL url = new URL(site);
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                int responseCode = connection.getResponseCode();
                if (responseCode < 200 || responseCode > 300) {
                    System.out.println(site + " : " + connection.getResponseMessage());
                } else {
                    System.out.println(site + " : " + connection.getResponseCode() + " (OK)");
                }
            } catch (IOException e) {
                System.out.println(site + " : " + "Adress not registered");
            }
        }
    }
}