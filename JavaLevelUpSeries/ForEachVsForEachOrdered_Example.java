package Prac;

import java.util.Arrays;
import java.util.List;

public class ForEachVsForEachOrdered_Example {

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
            return id + " - " + name;
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
        
        // Example 1 - Sequential Stream using forEach()
        System.out.println("=== Sequential Stream (forEach) ===");
        employees.stream()
                .forEach(emp -> System.out.println(emp.getName()));

        // Example 2 - Parallel Stream using forEach()
        System.out.println("\n=== Parallel Stream (forEach) ===");
        employees.parallelStream()
                .forEach(emp -> System.out.println(emp.getName()));

        // Example 3 - Parallel Stream using forEachOrdered()
        System.out.println("\n=== Parallel Stream (forEachOrdered) ===");
        employees.parallelStream()
                .forEachOrdered(emp -> System.out.println(emp.getName()));
        
        // Real-World Example 1 - Report Generation (Order Not Important)
        System.out.println("\n=== Real-World: Report Generation ===");
        employees.parallelStream()
                .forEach(emp -> {
                    double bonus = emp.getSalary() * 0.10;
                    System.out.printf(
                            "[%s] Generated Bonus Report -> %s : $%.2f%n",
                            Thread.currentThread().getName(),emp.getName(), bonus
                    );
                });


        // Real-World Example 2 - Employee Export (Order Important)
        System.out.println("\n=== Real-World: Ordered Employee Export ===");
        employees.parallelStream()
                .forEachOrdered(emp -> {
                    System.out.printf(
                            "Exporting -> ID: %d | Name: %-8s | Dept: %-7s | Salary: $%d%n",
                            emp.getId(),emp.getName(),emp.getDepartment(),emp.getSalary()
                    );
                });
        
        
    }
}
