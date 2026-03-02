package Prac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collectors_partitioningBy_Example {
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
        
     // Example 1: Partition employees based on salary > 6000
        Map<Boolean, List<Employee>> salaryPartition =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                emp -> emp.getSalary() > 6000
                        ));

        System.out.println("Employees Partitioned By Salary > 6000");

        System.out.println("\nHigh Salary Employees:");
        salaryPartition.get(true).forEach(System.out::println);
        System.out.println("\nLow Salary Employees:");
        salaryPartition.get(false).forEach(System.out::println);


        // Example 2: Average salary for IT vs Non-IT employees
        Map<Boolean, Double> avgSalary =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                emp -> emp.getDepartment().equals("IT"),
                                Collectors.averagingInt(Employee::getSalary)
                        ));

        System.out.println("\nAverage Salary (IT vs Non-IT):");
        System.out.println("IT -> " + avgSalary.get(true));
        System.out.println("Non-IT -> " + avgSalary.get(false));
    }
}
