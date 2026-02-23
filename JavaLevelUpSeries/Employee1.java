package com.eclothing.clothing.programming;

public class Employee1 {
    // for EmployeeStreamExample prog

    private int id;
    private String name;
    private String department;
    private double salary;
    private boolean active;
    private String gender;

    // Constructor
    public Employee1(int id, String name, String department,
                    double salary, boolean active, String gender) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
        this.gender = gender;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isActive() {
        return active;
    }

    public String getGender() {
        return gender;
    }

    // toString() for easy printing
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                ", gender='" + gender + '\'' +
                '}';
    }
}
