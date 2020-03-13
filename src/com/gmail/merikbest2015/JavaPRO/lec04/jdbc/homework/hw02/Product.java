package com.gmail.merikbest2015.JavaPRO.lec04.jdbc.homework.hw02;

public class Product {
    private String productType;
    private String productName;
    private int price;

    public Product() {
    }

    public Product(String productType, String productName, int price) {
        this.productType = productType;
        this.productName = productName;
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}