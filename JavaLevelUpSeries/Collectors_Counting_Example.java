package Prac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collectors_Counting_Example  {
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

        // Example 1 - Count total employees
        Long totalEmployees = employees.stream()
                .collect(Collectors.counting());

        System.out.println("Total Employees: " + totalEmployees);


        // Example 2 - Count employees by department
        Map<String, Long> countByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));

        System.out.println("\nEmployee Count by Department:");
        countByDepartment.forEach((dept, count) ->
                System.out.println(dept + " -> " + count)
        );
    }
}