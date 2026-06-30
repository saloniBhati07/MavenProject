package com.company.training;
public class Employee {
    private int id;
    private String name;
    private double salary;
    public Employee(int id, String name, double salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }
    public void Displaydetails() {
        System.out.println("Employee ID:"+id);
        System.out.println("Employee Name:"+name);
        System.out.println("EMployee Salary:"+salary);
        
    }
    
}
