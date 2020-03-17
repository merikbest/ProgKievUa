package com.gmail.merikbest2015.JavaOOP.homework.lec10.network.practice.prac01;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try{
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println(address);
            System.out.println(Arrays.toString(address.getAddress()));



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
