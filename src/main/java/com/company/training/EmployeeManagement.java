package com.company.training;

import java.sql.*;
import java.util.Scanner;

public class EmployeeManagement {

    static final String URL = "jdbc:postgresql://localhost:5432/employee%20db";
    static final String USER = "postgres";
    static final String PASSWORD = "Saloni@2007.";
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            while (true) {

                System.out.println("\n===== Employee Management =====");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String department = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        String insertQuery =
                                "INSERT INTO employee(name, department, salary) VALUES (?, ?, ?)";

                        PreparedStatement ps = con.prepareStatement(insertQuery);

                        ps.setString(1, name);
                        ps.setString(2, department);
                        ps.setDouble(3, salary);

                        int rows = ps.executeUpdate();

                        if (rows > 0) {
                            System.out.println("Employee Added Successfully!");
                        } else {
                            System.out.println("Failed to Add Employee.");
                        }

                        ps.close();
                        break;

                    case 2:

                        String selectQuery = "SELECT * FROM employee";

                        Statement stmt = con.createStatement();

                        ResultSet rs = stmt.executeQuery(selectQuery);

                        System.out.println("\nID\tName\tDepartment\tSalary");

                        while (rs.next()) {

                            System.out.println(
                                    rs.getInt("id") + "\t"
                                            + rs.getString("name") + "\t"
                                            + rs.getString("department") + "\t"
                                            + rs.getDouble("salary")
                            );
                        }

                        rs.close();
                        stmt.close();
                        break;

                    case 3:

                        System.out.println("Thank You!");
                        sc.close();
                        return;

                    default:

                        System.out.println("Invalid Choice!");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}