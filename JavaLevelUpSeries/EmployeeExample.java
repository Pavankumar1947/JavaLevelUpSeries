package com.eclothing.clothing.programming.Streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeExample {
    public static void main(String[] args) {
        List<Employee2> employees = List.of(
                new Employee2(1, "Pavan", "IT", 60000, 28),
                new Employee2(2, "Ravi", "HR", 45000, 32),
                new Employee2(3, "Anil", "IT", 80000, 35),
                new Employee2(4, "Kiran", "Finance", 70000, 30),
                new Employee2(5, "Suresh", "HR", 50000, 25)
        );

        // Filter Employees by Department (IT)
        List<Employee2> itDept = employees.stream()
                .filter(e->e.getDepartment().equals("IT"))
                .collect(Collectors.toList());
        itDept.forEach(System.out::println);

        //Get Employee Names Only
        List<String> eName = employees.stream().
                map(Employee2::getName)
                .collect(Collectors.toList());
        System.out.println(eName);

        // Employees with Salary > 60,000
         employees.stream().filter(e->e.getSalary() > 60000).forEach(System.out::println);

        //Count Employees per Department
        Map<String,Long> countEmpPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment, Collectors.counting()));
        System.out.println(countEmpPerDept);

        // Highest Paid Employee
       Employee2 highSal = employees.stream().max(Comparator.comparing(Employee2::getSalary)).orElse(null);
        System.out.println(highSal);

        //Average Salary per Department
         Map<String, Double >  avgSalPerDept= employees.stream()
                 .collect(Collectors.groupingBy(Employee2::getDepartment, Collectors.averagingDouble(Employee2::getSalary)));
        System.out.println(avgSalPerDept);

        //Sort Employees by Salary (Descending)
        employees.stream().sorted(Comparator.comparing(Employee2::getSalary).reversed()).forEach(System.out::println);

        // Find Youngest Employee
        Employee2 youngestEmp = employees.stream().min(Comparator.comparing(Employee2::getAge)).orElse(null);
        System.out.println(youngestEmp);

        // Department-wise Highest Salary
        Map<String, Optional<Employee2>> highestSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment ,Collectors.maxBy(Comparator.comparing(Employee2::getSalary))));
        highestSalaryByDept.forEach((k , v) -> System.out.println(k + " " + v.get()));

        //Convert Employee List to Map (ID → Name)
        Map<Integer ,String> empMap = employees.stream().collect(Collectors.toMap(Employee2::getId, Employee2::getName));
        System.out.println(empMap);

        // Check If Any Employee Salary > 1 Lakh
        boolean exist = employees.stream().anyMatch(e->e.getSalary() > 100000);
        System.out.println(exist);


        //Partition Employees Based on Salary > 60k
        Map<Boolean, List<Employee2>> partitioned =employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 60000));
        System.out.println(partitioned);


        // Total Salary of All Employees
        double totalSalary = employees.stream().
                mapToDouble(Employee2::getSalary)
                .sum();
        System.out.println(totalSalary);

        // second hightest salary
        Employee2 secondHighest = employees.stream().sorted(Comparator.comparing(Employee2::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondHighest);

        // Second Highest Salary per Department
        Map<String, Optional<Employee2>> secondHighestByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee2::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparing(Employee2::getSalary).reversed())
                                                .skip(1)
                                                .findFirst()
                                )
                        ));

        secondHighestByDept.forEach((d, e) ->System.out.println(d + " -> " + e.orElse(null)));

        // Top 3 Highest Paid Employees
        List<Employee2> top3 = employees.stream()
                .sorted(Comparator.comparing(Employee2::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(top3);

        // Group Employees by Department and Sort by Salary
        Map<String, List<Employee2>> groupedSorted =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee2::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparing(Employee2::getSalary).reversed())
                                                .collect(Collectors.toList())
                                )
                        ));

        System.out.println(groupedSorted);

        //Employees Whose Name Starts With a Vowel
        employees.stream()
                .filter(e -> e.getName().matches("(?i)^[aeiou].*"))
                .forEach(System.out::println);

        // Department with Highest Total Salary
        Map.Entry<String, Double> highestPayingDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee2::getDepartment,
                                Collectors.summingDouble(Employee2::getSalary)
                        ))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .orElse(null);

        System.out.println(highestPayingDept);


        // Convert List<Employee> → Map<Department, List<Employee Names>>
        Map<String, List<String>> deptEmpNames =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee2::getDepartment,
                                Collectors.mapping(Employee2::getName, Collectors.toList())
                        ));

        System.out.println(deptEmpNames);


        // Find Employees Earning Above Department Average
        Map<String, Double> deptAvg =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee2::getDepartment,
                                Collectors.averagingDouble(Employee2::getSalary)
                        ));

        List<Employee2> aboveAvg =
                employees.stream()
                        .filter(e -> e.getSalary() > deptAvg.get(e.getDepartment()))
                        .collect(Collectors.toList());
        System.out.println(aboveAvg);
    }
}
