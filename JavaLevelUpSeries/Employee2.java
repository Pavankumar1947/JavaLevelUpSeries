package com.eclothing.clothing.programming.Streams;

public class Employee2 {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee2(int id, String name, String department, double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return id + " " + name + " " + department + " " + salary + " " + age;
    }
}
