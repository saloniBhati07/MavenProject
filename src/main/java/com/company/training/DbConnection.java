package com.company.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/employee%20db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Saloni@2007.";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("✅ Database Connected Successfully!");

        } catch (SQLException e) {

            System.out.println("❌ Connection Failed!");
            e.printStackTrace();

        }
    }
}