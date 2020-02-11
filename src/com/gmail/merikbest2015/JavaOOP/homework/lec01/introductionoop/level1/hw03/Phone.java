package com.gmail.merikbest2015.JavaOOP.homework.lec01.introductionoop.level1.hw03;

import java.util.List;

public class Phone {
    private int phoneNumber;

    public Phone() {
    }

    public Phone(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void call(int number, List<Integer> numbersList) {
        List<Integer> list = numbersList;

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(number)) {
                System.out.println("Набраный номер не существует");
            } else {
                System.out.println("Звоним по номеру " + number);
            }
        }
    }
}