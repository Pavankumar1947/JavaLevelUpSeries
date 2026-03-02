package Prac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collectors_toList_Example {
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

     // eg 1 - Collect employee names into List
     List<String> names = employees.stream()
             .map(Employee::getName)
             .collect(Collectors.toList());
             System.out.println("Names List: " + names);
     
     // eg 2 - Filter employees with salary > 6000 and collect into List
     List<Employee> highSalaryEmployees = employees.stream()
             .filter(emp -> emp.getSalary() > 6000)
             .collect(Collectors.toList());
     
             System.out.println("Employees with Salary > 6000:");
             highSalaryEmployees.forEach(System.out::println);
    }
}