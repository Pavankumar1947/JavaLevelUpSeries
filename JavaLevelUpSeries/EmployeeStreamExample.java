package com.eclothing.clothing.programming;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamExample {
    public static void main(String[] args) {
        List<Employee1> employees = Arrays.asList(
                new Employee1(1, "Amit", "IT", 70000,true,"M"),
                new Employee1(2, "Ravi", "HR", 50000,true,"M"),
                new Employee1(3, "Sita", "IT", 90000,true,"F"),
                new Employee1(4, "John", "Finance", 80000,true,"M"),
                new Employee1(5, "Meena", "HR", 60000,true,"F"),
                new Employee1(6, "Kiran", "Finance", 75000,true,"M")
        );

        //Employee Count per Department
        Map<String, Long> empCountByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee1::getDepartment,
                                Collectors.counting()
                        ));

        System.out.println("Employee Count per Department:");
        empCountByDept.forEach((k, v) ->
                System.out.println(k + " -> " + v)
        );


        // Highest Paid Employee per Department
        Map<String, Optional<Employee1>> highestPaidByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee1::getDepartment,
                                Collectors.maxBy(
                                        Comparator.comparing(Employee1::getSalary)
                                )
                        ));

        System.out.println("\nHighest Paid Employee per Department:");
        highestPaidByDept.forEach((k, v) ->
                System.out.println(k + " -> " + v.get())
        );

        //Max & Min Salary per Department
        Map<String, DoubleSummaryStatistics> salaryStats =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee1::getDepartment,
                                Collectors.summarizingDouble(Employee1::getSalary)
                        ));

        System.out.println("\nMax & Min Salary per Department:");
        salaryStats.forEach((k, v) -> {
            System.out.println(
                    k + " -> Max: " + v.getMax() + ", Min: " + v.getMin()
            );
        });
    }


}
