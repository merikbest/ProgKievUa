package com.gmail.merikbest2015.JavaPRO.lec04.jdbc.homework.hw02;

import java.sql.*;

public class DataBase {
    private static Connection connection;

    public void initDB() {
        try (Statement st = connection.createStatement()) {
            st.execute("DROP TABLE IF EXISTS Products");
            st.execute("CREATE TABLE Products (product_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "product_type VARCHAR(40), " +
                    "product_name VARCHAR(40), " +
                    "price INT)");
            st.execute("DROP TABLE IF EXISTS Clients");
            st.execute("CREATE TABLE Clients (client_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "client_first_name VARCHAR(40), " +
                    "client_last_name VARCHAR(40), " +
                    "phone INT)");
            st.execute("DROP TABLE IF EXISTS Orders");
            st.execute("CREATE TABLE Orders (order_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "client_id INT, " +
                    "product_id INT, " +
                    "price INT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewTable(String table) {
        String sql = "SELECT * FROM " + table + ";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++)
                System.out.print(metaData.getColumnName(i) + "\t\t");
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.print(resultSet.getString(i) + "\t\t");
                }
                System.out.println();
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProduct(Product product) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO Products (product_type, product_name, price) VALUES(?, ?, ?)")) {
            ps.setString(1, product.getProductType());
            ps.setString(2, product.getProductName());
            ps.setInt(3, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertClient(Client client) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO Clients (client_first_name, client_last_name, phone) VALUES(?, ?, ?)")) {
            ps.setString(1, client.getClientFirstName());
            ps.setString(2, client.getClientLastName());
            ps.setInt(3, client.getClientPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOrder(Order order) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO Orders (client_id, product_id) VALUES(?, ?)")) {
            ps.setInt(1, order.getClientId());
            ps.setInt(2, order.getProductId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}