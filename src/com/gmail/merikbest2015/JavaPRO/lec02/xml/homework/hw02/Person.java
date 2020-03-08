package com.gmail.merikbest2015.JavaPRO.lec02.xml.homework.hw02;

public class Person {
    private String name;
    private String surname;
    private String[] phones;
    private String[] sites;
    private Address address;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String[] getPhones() {
        return phones;
    }

    public String[] getSites() {
        return sites;
    }

    public Address getAddress() {
        return address;
    }
}