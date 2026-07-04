package com.eclothing.clothing.prog;

import java.util.Arrays;
import java.util.List;

public class Stream_AllMatch_Example {
    static class Employee {
        private int id;
        private String name;
        private String department;
        private int salary;

        public Employee(int id, String name, String department, int salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public int getSalary() { return salary; }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Pavan", "IT", 5000),
                new Employee(2, "Pk", "HR", 7000),
                new Employee(3, "Manohar", "IT", 6000),
                new Employee(4, "Darshan", "Finance", 9000),
                new Employee(5, "Mohan", "HR", 8000)
        );

        // Example 1: Do all employees have a valid salary?
        boolean allHaveSalary = employees.stream()
                .allMatch(emp -> emp.getSalary() > 0);
        System.out.println("All employees have valid salary : " + allHaveSalary);

        // Example 2: Are all employees in the IT department?
        boolean allITEmployees = employees.stream()
                .allMatch(emp -> "IT".equals(emp.getDepartment()));
        System.out.println("All employees belong to IT      : " + allITEmployees);

        // Example 3: Are all employees earning at least $5000?
        boolean allAbove5000 = employees.stream()
                .allMatch(emp -> emp.getSalary() >= 5000);
        System.out.println("All employees earn >= $5000     : " + allAbove5000);
    }
}
