package com.gmail.merikbest2015.JavaPRO.lec02.xml.practice.pr01;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXML {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element element = document.createElement("catalog");
            document.appendChild(element);

            //book1
            Element book1 = document.createElement("book1");
            element.appendChild(book1);

            Element author1 = document.createElement("author1");
            author1.setTextContent("Author 1");
            book1.appendChild(author1);

            //book2
            Element book2 = document.createElement("book2");
            element.appendChild(book2);

            Element author2 = document.createElement("author2");
            author2.setTextContent("Author 2");
            book2.appendChild(author2);

            //save
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("2.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}