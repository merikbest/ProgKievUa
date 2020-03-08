package com.gmail.merikbest2015.JavaPRO.lec02.xml.homework.hw01;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "train")
public class Train {
    private String id;
    private String from;
    private String to;
    private String date;
    private String departure;

    public Train() {
    }

    public Train(String id, String from, String to, String date, String departure) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }

    public String getFrom() {
        return from;
    }

    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    @XmlElement
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Train{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date='" + date + '\'' +
                ", departure='" + departure + '\'' +
                '}';
    }
}