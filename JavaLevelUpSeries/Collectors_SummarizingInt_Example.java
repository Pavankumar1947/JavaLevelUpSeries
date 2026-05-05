package com.eclothing.clothing.programming.javaLevelUpSeries;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Collectors_SummarizingInt_Example {

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

        public int getSalary() { return salary; }
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Pavan", "IT", 5000),
                new Employee(2, "Pk", "HR", 7000),
                new Employee(3, "Manohar", "IT", 6000),
                new Employee(4, "Ravi", "Finance", 9000),
                new Employee(5, "Arjun", "HR", 8000)
        );

        IntSummaryStatistics stats = employees.stream()
                .collect(Collectors.summarizingInt(Employee::getSalary));

        System.out.println("Count   : " + stats.getCount());
        System.out.println("Sum     : " + stats.getSum());
        System.out.println("Min     : " + stats.getMin());
        System.out.println("Max     : " + stats.getMax());
        System.out.println("Average : " + stats.getAverage());
    }
}
