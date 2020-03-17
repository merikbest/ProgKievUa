package com.gmail.merikbest2015.JavaOOP.homework.lec01.introductionoop.level1.hw03;

public class PhoneSolution {
    public static void main(String[] args) {
        Phone phone1 = new Phone(4146666);
        Phone phone2 = new Phone(4146667);
        Phone phone3 = new Phone(4146668);
        Phone phone4 = new Phone(4146669);
        Phone phone5 = new Phone(4146670);
        Phone phone = new Phone();
        Network network = new Network();

        network.connectNumberToNetwork(phone1.getPhoneNumber());
        phone.call(4146666, network.getList());
    }
}
