package Prac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collectors_SummingInt_Example  {
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

        // Example 1 - Total salary of all employees Using Streams
        Integer totalSalary = employees.stream()
                .collect(Collectors.summingInt(Employee::getSalary));

        System.out.println("Total Salary: " + totalSalary);
        
        // Normal Way (Traditional Loop)
        int totalSalaryLoop = 0;
        for (Employee emp : employees) {
            totalSalaryLoop += emp.getSalary();
        }

        System.out.println("\nTotal Salary using Loop: " + totalSalaryLoop);

        // Example 2 - Total salary by department
        Map<String, Integer> salaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)
                ));

        System.out.println("\nTotal Salary by Department:");
        salaryByDept.forEach((dept, sum) ->
                System.out.println(dept + " -> " + sum)
        );
    }
}