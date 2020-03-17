package com.gmail.merikbest2015.JavaPRO.lec04.jdbc.homework.hw02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static Connection connection;
    private static DataBase dataBase;
    private static AddToDataBase addToDataBase;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            dataBase.initDB();
            view();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void view() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("1: add clients");
                System.out.println("2: add products");
                System.out.println("3: add orders");
                System.out.println("4: view clients");
                System.out.println("5: view products");
                System.out.println("6: view orders");
                System.out.print("-> ");
                String line = reader.readLine();
                switch (line) {
                    case "1":
                        addToDataBase.addClient();
                        break;
                    case "2":
                        addToDataBase.addProduct();
                        break;
                    case "3":
                        addToDataBase.addOrder();
                        break;
                    case "4":
                        viewClients();
                        break;
                    case "5":
                        viewProducts();
                        break;
                    case "6":
                        viewOrders();
                        break;
                    default:
                        return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void viewClients() {
        dataBase.viewTable("Clients");
    }

    private static void viewProducts() {
        dataBase.viewTable("Products");
    }

    private static void viewOrders() {
        dataBase.viewTable("Orders");
    }
}