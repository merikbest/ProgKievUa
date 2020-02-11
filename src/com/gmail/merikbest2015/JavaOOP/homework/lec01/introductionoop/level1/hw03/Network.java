package com.gmail.merikbest2015.JavaOOP.homework.lec01.introductionoop.level1.hw03;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Integer> list;

    public Network() {
    }

    public List<Integer> getList() {
        return list;
    }

    public void connectNumberToNetwork(int registeredNumber) {
        list = new ArrayList<>();
        list.add(registeredNumber);
    }
}
