package com.eclothing.clothing.programming.javaLevelUpSeries;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors_averagingInt_Example{
    static class Employee {
        private int id;
        private String name;
        private String department;
        private int salary;

        public Employee(int id, String name, String department, int salary) {
            this.id = id; this.name = name; this.department = department; this.salary = salary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public int getSalary() { return salary; }

        @Override
        public String toString() {
            return name + " (" + department + " - " + salary + ")";
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Pavan", "IT", 5000),
                new Employee(2, "Pk", "HR", 7000),
                new Employee(3, "Manohar", "IT", 6000),
                new Employee(4, "Ravi", "Finance", 9000),
                new Employee(5, "Arjun", "HR", 8000)
        );

        // 1️ Average salary of all employees
        Double avgSalary = employees.stream()
                .collect(Collectors.averagingInt(Employee::getSalary));

        System.out.println("Average Salary: " + avgSalary);

        // 2️ Average salary by department
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)
                ));

        System.out.println("\nAverage Salary by Department:");
        avgSalaryByDept.forEach((dept, avg) ->
                System.out.println(dept + " -> " + avg)
        );
    }
}

