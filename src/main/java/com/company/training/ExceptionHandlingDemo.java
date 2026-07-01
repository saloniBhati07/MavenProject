package com.company.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExceptionHandlingDemo {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/employee%20db";
        String username = "postgres";
        String password = "Saloni@2007.";
        try {

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            // Intentionally using an invalid table name to demonstrate exception handling
            String sql = "INSERT INTO employeee(name, department, salary) VALUES('Ajay','IT',50000)";

            stmt.executeUpdate(sql);

            System.out.println("Employee Inserted Successfully.");

            stmt.close();
            con.close();

        } catch (SQLException e) {

            System.out.println("Database Error!");
            System.out.println("Reason: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Unexpected Error!");
            System.out.println(e.getMessage());

        }

        System.out.println("Application is still running...");
    }
}