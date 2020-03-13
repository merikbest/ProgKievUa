package com.gmail.merikbest2015.JavaPRO.lec04.jdbc.homework.hw02;

public class Order {
    private int clientId;
    private int productId;

    public Order() {
    }

    public Order(int clientId, int productId) {
        this.clientId = clientId;
        this.productId = productId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}