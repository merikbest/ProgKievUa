package com.gmail.merikbest2015.JavaPRO.lec04.jdbc.homework.hw01;

import java.sql.*;
import java.util.Scanner;

public class Flats {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb";
    static Connection conn;

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(DB_CONNECTION);
            if (conn != null)
                conn.close();
            initDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void initDB() {
        try (Statement st = conn.createStatement()) {
            st.execute("DROP TABLE IF EXISTS Flats");
            st.execute("CREATE TABLE Flats (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, District VARCHAR(40), Address VARCHAR(40), Area INT, Flat_amount INT, Price INT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addFlat(Scanner sc) {
        System.out.print("Enter District: ");
        String district = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Area: ");
        int area = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Flat_amount: ");
        int flatAmount = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Price: ");
        int price = Integer.parseInt(sc.nextLine());

        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO Clients (district, address, area, flatAmount, price) VALUES(?, ?, ?, ?, ?)")) {
            ps.setString(1, district);
            ps.setString(2, address);
            ps.setInt(3, area);
            ps.setInt(4, flatAmount);
            ps.setInt(5, price);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewFlats() {
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Flats");
             ResultSet rs = ps.executeQuery()) {
            ResultSetMetaData md = rs.getMetaData();

            for (int i = 1; i <= md.getColumnCount(); i++)
                System.out.print(md.getColumnName(i) + "\t\t");
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}