package com.company.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchEmployee {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/employee%20db";
        String username = "postgres";
        String password = "Saloni@2007.";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stmt = con.createStatement();
        ) {

            String query = "SELECT * FROM employee";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("ID\tName\tDepartment\tSalary");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.println(id + "\t" + name + "\t" + department + "\t" + salary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}