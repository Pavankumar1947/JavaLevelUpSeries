package Prac;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream_reduce_Example {
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

        @Override
        public String toString() {
            return id + " - " + name + " ($" + salary + ")";
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

        // reduce() Examples

        // 1. Highest Salary
        int highestSalary = employees.stream().map(Employee::getSalary).reduce(0, Integer::max);
        System.out.println("Highest Salary = " + highestSalary);

        // 2. Concatenate Employee Names
        String employeeNames = employees.stream().map(Employee::getName)
                .reduce("", (a, b) -> a.isEmpty() ? b : a + ", " + b);
        System.out.println("Employee Names = " + employeeNames);

        // collect() Examples
        // 1. Collect IT Employees into a List
        List<Employee> itEmployees = employees.stream()
                .filter(emp -> "IT".equals(emp.getDepartment())).collect(Collectors.toList());
        System.out.println("\nIT Employees:");
        itEmployees.forEach(System.out::println);

        // 2. Collect Employee Names into a List
        List<String> names = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println("\nNames List = " + names);

       
    }
}
