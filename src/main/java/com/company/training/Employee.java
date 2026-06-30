package com.company.training;

public class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("----------------------------");
    }
}