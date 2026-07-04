package com.eclothing.clothing.prog;

import java.util.Arrays;
import java.util.List;

public class Stream_NoneMatch_Example {
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

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return id + " - " + name + " (" + department + ", $" + salary + ")";
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Pavan", "IT", 5000),
                new Employee(2, "Pk", "HR", 7000),
                new Employee(3, "Manohar", "IT", 6000),
                new Employee(4, "Darshan", "Finance", 9000),
                new Employee(5, "Mohan", "HR", 8000)
        );

        // Example 1: No Intern employees
        boolean noInterns = employees.stream()
                .noneMatch(emp -> "Intern".equals(emp.getDepartment()));
        System.out.println("No Intern Employees       : " + noInterns);

        // Example 2: No employee earning less than $5000
        boolean noLowSalary = employees.stream()
                .noneMatch(emp -> emp.getSalary() < 5000);
        System.out.println("No Employee Salary < $5000: " + noLowSalary);

        // Example 3: No Finance employees
        boolean noFinance = employees.stream()
                .noneMatch(emp -> "Finance".equals(emp.getDepartment()));
        System.out.println("No Finance Employees      : " + noFinance);

        // Example 4: No employee named "Rahul"
        boolean noRahul = employees.stream()
                .noneMatch(emp -> "Rahul".equals(emp.getName()));
        System.out.println("No Employee Named Rahul   : " + noRahul);
    }
}
