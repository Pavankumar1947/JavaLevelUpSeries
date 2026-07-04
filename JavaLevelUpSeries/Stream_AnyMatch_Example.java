package com.eclothing.clothing.prog;
import java.util.Arrays;
import java.util.List;

public class Stream_AnyMatch_Example {
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
            return id + " - " + name + " ($" + salary + ")";
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

        // Example 1: Any employee earning more than $8000?
        boolean hasHighSalary = employees.stream().anyMatch(emp -> emp.getSalary() > 8000);
        System.out.println("Any employee earning > $8000 : " + hasHighSalary);

        // Example 2: Any employee from Finance department?
        boolean hasFinanceEmployee = employees.stream()
                .anyMatch(emp -> "Finance".equals(emp.getDepartment()));
        System.out.println("Finance employee available   : " + hasFinanceEmployee);

        // Example 3: Any employee named 'Rahul'?
        boolean hasRahul = employees.stream().anyMatch(emp -> "Rahul".equals(emp.getName()));
        System.out.println("Employee named Rahul exists  : " + hasRahul);
    }
}
