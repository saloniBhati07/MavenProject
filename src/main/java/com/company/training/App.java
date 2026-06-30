package com.company.training;

public class App {

    public static void main(String[] args) {

        Employee emp1 = new Employee(101, "Saloni", "HR", 45000);
        Employee emp2 = new Employee(102, "Rahul", "IT", 60000);
        Employee emp3 = new Employee(103, "Priya", "Finance", 55000);

        emp1.displayEmployee();
        emp2.displayEmployee();
        emp3.displayEmployee();
    }
}