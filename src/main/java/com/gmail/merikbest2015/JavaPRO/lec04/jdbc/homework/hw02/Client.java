package com.gmail.merikbest2015.JavaPRO.lec04.jdbc.homework.hw02;

public class Client {
    private String clientFirstName;
    private String clientLastName;
    private int clientPhone;

    public Client() {
    }

    public Client(String clientFirstName, String clientLastName, int clientPhone) {
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.clientPhone = clientPhone;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public int getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(int clientPhone) {
        this.clientPhone = clientPhone;
    }
}