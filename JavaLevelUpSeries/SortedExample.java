package com.eclothing.clothing.programming.Streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Employee {
        String name;
        int salary;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Pavan", 5000),
                new Employee("Pk", 7000),
                new Employee("Manohar", 6000)
        );

        // Sort by salary ascending
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());

        sortedBySalary.forEach(e ->
                System.out.println(e.getName() + " : " + e.getSalary())
        );
    }
}
