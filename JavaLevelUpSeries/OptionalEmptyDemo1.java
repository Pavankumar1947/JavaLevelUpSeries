package com.eclothing.clothing.prog;


import java.util.Optional;

public class OptionalEmptyDemo1 {

    static class Employee {
        private int id;
        private String name;
        private String department;

        public Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }
    }

    // Method returns Optional.empty() when employee is not found
    public static Optional<Employee> findEmployeeById(Employee[] employees, int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee(1, "Pavan", "IT"),
                new Employee(2, "Pk", "HR"),
                new Employee(3, "Manohar", "IT"),
                new Employee(4, "Darshan", "Finance"),
                new Employee(5, "Mohan", "HR")
        };

        // Example 1: Employee exists
        Optional<Employee> employee1 = findEmployeeById(employees, 1);

        System.out.println("Employee found : " + employee1.isPresent());


        // Example 2: Employee does not exist
        Optional<Employee> employee6 = findEmployeeById(employees, 6);
        System.out.println("Employee found : " + employee6.isPresent());


        // Example 3: Handle empty Optional with orElse()
        String employeeName = findEmployeeById(employees, 10)
                .map(Employee::getName)
                .orElse("Employee Not Found");

        System.out.println("Employee name  : " + employeeName);
    }
}
