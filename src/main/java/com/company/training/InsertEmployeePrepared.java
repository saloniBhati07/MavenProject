package com.company.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertEmployeePrepared {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/employee%20db";
        String username = "postgres";
        String password = "Saloni@2007.";

        String sql = "INSERT INTO employee(name, department, salary) VALUES (?, ?, ?)";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {

            // Employee Details
            pstmt.setString(1, "Ravi");
            pstmt.setString(2, "QA");
            pstmt.setDouble(3, 45000);

            int rows = pstmt.executeUpdate();

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