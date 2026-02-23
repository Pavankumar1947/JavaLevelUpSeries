package com.eclothing.clothing.programming.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DistinctExample {
    static class Employee {
        private String name;
        private String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return name + " (" + department + ")";
        }
    }

    public static void main(String[] args) {
        // Distinct on primitive numbers
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique Numbers:-> " + uniqueNumbers);

        // Distinct on object property
        List<Employee> employees = Arrays.asList(new Employee("Pavan", "IT"),
                new Employee("Pk", "HR"),
                new Employee("Manohar", "IT"),
                new Employee("Ravi", "Finance"),
                new Employee("Arjun", "HR"));

        System.out.println("Unique Departments:");
        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);
    }
}
