package com.gmail.merikbest2015.JavaPRO.lec04.jdbc.homework.hw02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddToDataBase {
    private static DataBase dataBase;

    public void addProduct() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter product type: ");
            String productType = reader.readLine();
            System.out.print("Enter product name: ");
            String productName = reader.readLine();
            System.out.print("Enter product price: ");
            int price = Integer.parseInt(reader.readLine());
            Product product = new Product(productType, productName, price);
            dataBase.insertProduct(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addClient() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter client first name: ");
            String clientFirstName = reader.readLine();
            System.out.print("Enter client last name: ");
            String clientLastName = reader.readLine();
            System.out.print("Enter client phone: ");
            int clientPhone = Integer.parseInt(reader.readLine());
            Client client = new Client(clientFirstName, clientLastName, clientPhone);
            dataBase.insertClient(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addOrder() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter client Id: ");
            int clientId = Integer.parseInt(reader.readLine());
            System.out.print("Enter product Id: ");
            int productId = Integer.parseInt(reader.readLine());
            Order order = new Order(clientId, productId);
            dataBase.insertOrder(order);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}