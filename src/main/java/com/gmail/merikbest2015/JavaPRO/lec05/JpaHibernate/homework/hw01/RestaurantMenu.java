package com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw01;

import javax.persistence.*;

@Entity
@Table(name = "restaurantMenu")
public class RestaurantMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String dishName;
    private int dishPrice;
    private int dishWeight;
    private String discount;

    public RestaurantMenu() {
    }

    public RestaurantMenu(String dishName, int dishPrice, int dishWeight, String discount) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishWeight = dishWeight;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(int dishPrice) {
        this.dishPrice = dishPrice;
    }

    public int getDishWeight() {
        return dishWeight;
    }

    public void setDishWeight(int dishWeight) {
        this.dishWeight = dishWeight;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "RestaurantMenu:" +
                "Блюдо - " + dishName +
                ", цена - " + dishPrice +
                ", вес - " + dishWeight +
                ", скидка - " + discount;
    }
}