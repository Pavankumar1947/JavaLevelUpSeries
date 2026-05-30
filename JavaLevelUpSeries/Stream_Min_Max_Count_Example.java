package Prac;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

public class Stream_Min_Max_Count_Example {
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

        // count()
        long highEarnersCount = employees.stream()
                .filter(emp -> emp.getSalary() > 6000).count();
        System.out.println("Result (Employees earning > $6000): " + highEarnersCount);
        System.out.println("----------------------------------------------------------------------");

        // min()
        Employee lowestPaidEmployee = employees.stream()
                .min(Comparator.comparingInt(Employee::getSalary)).orElse(null);
        System.out.println("Lowest Paid Employee : " + lowestPaidEmployee);
        System.out.println("----------------------------------------------------------------------");

        // max()
        Employee highestPaidEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println("Highest Paid Employee: " + highestPaidEmployee);
        System.out.println("----------------------------------------------------------------------");
        
        // Count + Min + Max together using IntSummaryStatistics
        IntSummaryStatistics salaryStats = employees.stream()
                .mapToInt(Employee::getSalary)
                .summaryStatistics();
        
        System.out.println("    Count: " + salaryStats.getCount());   
        System.out.println("    Min: $" + salaryStats.getMin());       
        System.out.println("    Max: $" + salaryStats.getMax());       
    }
}
