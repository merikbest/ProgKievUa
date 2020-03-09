package com.gmail.merikbest2015.JavaPRO.lec02.xml.homework.hw01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Solution2 {
    public static void main(String[] args) {
        Trains trains = new Trains();
        trains.add(new Train("1","Kyiv", "Donetsk", "19.12.2013", "15:05"));
        trains.add(new Train("2","Lviv", "Donetsk", "19.12.2013", "19:05"));

        try {
            File file = new File("src\\com\\gmail\\merikbest2015\\JavaPRO\\lec02\\xml\\homework\\hw01\\train2.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(trains, file);
            marshaller.marshal(trains, System.out);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            trains = (Trains) unmarshaller.unmarshal(file);

            for (Train train: trains.getTrains()) {
                if(train.getDeparture().startsWith("15")||train.getDeparture().startsWith("16")
                        ||train.getDeparture().startsWith("17")||train.getDeparture().startsWith("18")){
                    System.out.println(train);
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}