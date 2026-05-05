package com.eclothing.clothing.programming.javaLevelUpSeries;

import java.util.*;
import java.util.stream.Collectors;

public class Collectors_CollectingAndThen_Example {

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

        // ✅ Example 1 - Make Unmodifiable List of Employee Names
        List<String> unmodifiableNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));

        System.out.println("1️⃣ Unmodifiable Employee Names:");
        System.out.println(unmodifiableNames);


        // ✅ Example 2 - Get Highest Paid Employee
        Employee highestPaidEmployee = employees.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                        Optional::get
                ));

        System.out.println("\n2️⃣ Highest Paid Employee:");
        System.out.println(highestPaidEmployee);


        // ✅ Example 3 - Department-wise Count (Then Convert to Unmodifiable Map)
        Map<String, Long> deptCount = employees.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        ),
                        Collections::unmodifiableMap
                ));

        System.out.println("\n3️⃣ Department-wise Employee Count (Unmodifiable Map):");
        deptCount.forEach((dept, count) ->
                System.out.println(dept + " -> " + count)
        );
    }
}
