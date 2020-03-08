package com.gmail.merikbest2015.JavaPRO.lec02.xml.homework.hw01;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Solution1 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element trains = document.createElement("trains");
            document.appendChild(trains);
            Element train = document.createElement("train");
            train.setAttribute("id", "1");
            trains.appendChild(train);
            Element from = document.createElement("from");
            from.setTextContent("Kyiv");
            train.appendChild(from);
            Element to = document.createElement("to");
            to.setTextContent("Donetsk");
            train.appendChild(to);
            Element date = document.createElement("date");
            date.setTextContent("19.12.2013");
            train.appendChild(date);
            Element departure = document.createElement("departure");
            departure.setTextContent("15:05");
            train.appendChild(departure);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("src\\com\\gmail\\merikbest2015\\JavaPRO\\lec02\\xml\\homework\\hw01\\train.xml"));
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}