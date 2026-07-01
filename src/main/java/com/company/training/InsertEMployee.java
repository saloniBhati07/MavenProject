package com.company.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertEMployee {

    public static void main(String[] args) {


        String url = "jdbc:postgresql://localhost:5432/employee%20db";
        String username = "postgres";
        String password = "Saloni@2007.";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stmt = con.createStatement()
        ) {

            String query = "INSERT INTO employee(name, department, salary) "
                    + "VALUES('Ajay','IT',50000)";

            int rows = stmt.executeUpdate(query);

            if (rows > 0) {
                System.out.println("Employee Inserted Successfully!");
            } else {
                System.out.println("Employee Not Inserted.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}