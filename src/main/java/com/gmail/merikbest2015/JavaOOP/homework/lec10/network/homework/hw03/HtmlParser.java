package com.gmail.merikbest2015.JavaOOP.homework.lec10.network.homework.hw03;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlParser {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("href.txt"))) {
            Document doc = Jsoup.connect("https://stackoverflow.com/questions/30408174/jsoup-how-to-get-href").get();
            Elements links = doc.select("a");
            for (Element link : links) {
                writer.write(link.attr("abs:href") + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}