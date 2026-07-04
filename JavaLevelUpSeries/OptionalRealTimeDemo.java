package com.eclothing.clothing.prog;

import java.util.*;

public class OptionalRealTimeDemo {


    static class Employee {
        private final int id;
        private final String name;
        private final double salary;
        private final String status;

        public Employee(int id, String name, double salary, String status) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.status = status;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getSalary() { return salary; }
        public String getStatus() { return status; }
    }

    // Custom exception for fetch-or-throw pattern
    static class EmployeeNotFoundException extends RuntimeException {
        public EmployeeNotFoundException(String message) {
            super(message);
        }
    }

    // ---------- Repository Layer ----------
    static class EmployeeRepository {
        private final Map<Integer, Employee> database = new HashMap<>();

        public EmployeeRepository() {
            database.put(101, new Employee(101, "Alice", 9500, "ACTIVE"));
            database.put(102, new Employee(102, "Bob", 7200, "PENDING"));
            database.put(103, new Employee(103, "Charlie", 12000, "ACTIVE"));
        }

        // Simulates Spring Data JPA's findById() returning Optional
        public Optional<Employee> findById(int id) {
            return Optional.ofNullable(database.get(id));
        }

        public List<Employee> findAll() {
            return new ArrayList<>(database.values());
        }
    }

    // ---------- Service Layer ----------
    static class EmployeeService {
        private final EmployeeRepository repository;

        public EmployeeService(EmployeeRepository repository) {
            this.repository = repository;
        }

        // Pattern 2: Fetch-or-throw
        public Employee getEmployeeOrThrow(int id) {
            return repository.findById(id)
                    .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        }

        // Pattern 3: Chained transformation with map()
        public String getEmployeeName(int id) {
            return repository.findById(id)
                    .map(Employee::getName)
                    .orElse("Unknown Employee");
        }

        // Pattern 6: Validation chain with filter()
        public void processIfPending(int id) {
            repository.findById(id)
                    .filter(emp -> "PENDING".equals(emp.getStatus()))
                    .ifPresentOrElse(
                            emp -> System.out.println("Processing pending employee: " + emp.getName()),
                            () -> System.out.println("No pending employee found for id: " + id)
                    );
        }

        // Pattern 7: Combining Optional with Streams
        public Optional<Employee> getHighestPaidEmployee() {
            return repository.findAll().stream()
                    .max(Comparator.comparing(Employee::getSalary));
        }
    }

    // ---------- Main: simulating real usage ----------
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeService service = new EmployeeService(repository);

        System.out.println("---- 1. Repository Layer (ifPresentOrElse) ----");
        repository.findById(101).ifPresentOrElse(
                emp -> System.out.println("Found: " + emp.getName()),
                () -> System.out.println("Employee not found")
        );

        System.out.println("\n---- 2. Service Layer (fetch-or-throw) ----");
        try {
            Employee emp = service.getEmployeeOrThrow(999); // doesn't exist
            System.out.println("Employee: " + emp.getName());
        } catch (EmployeeNotFoundException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        System.out.println("\n---- 3. Chained Transformation with map() ----");
        System.out.println("Name for id 102: " + service.getEmployeeName(102));
        System.out.println("Name for id 999: " + service.getEmployeeName(999));

        System.out.println("\n---- 4. Configuration Lookup ----");
        Optional<String> configValue = Optional.ofNullable(System.getProperty("app.env"));
        String env = configValue.orElse("default");
        System.out.println("Environment: " + env);

        System.out.println("\n---- 5. Simulated REST Response Handling ----");
        System.out.println("Response for id 103: " + simulateRestResponse(repository, 103));
        System.out.println("Response for id 999: " + simulateRestResponse(repository, 999));

        System.out.println("\n---- 6. Validation Chain (filter + ifPresentOrElse) ----");
        service.processIfPending(102); // PENDING
        service.processIfPending(101); // ACTIVE, won't process

        System.out.println("\n---- 7. Combining Optional with Streams ----");
        service.getHighestPaidEmployee()
                .ifPresent(emp -> System.out.println("Top earner: " + emp.getName() + " ($" + emp.getSalary() + ")"));

        System.out.println("\n---- 8. Anti-pattern Demo: get() without check ----");
        try {
            Optional<Employee> optionalEmployee = repository.findById(999);
            Employee emp = optionalEmployee.get(); // Throws NoSuchElementException
            System.out.println(emp.getName());
        } catch (NoSuchElementException e) {
            System.out.println("Caught NoSuchElementException: " + e.getMessage());
        }
    }

    // Simulates a REST controller response using map/orElse
    private static String simulateRestResponse(EmployeeRepository repository, int id) {
        return repository.findById(id)
                .map(emp -> "200 OK - " + emp.getName())
                .orElse("404 Not Found");
    }
}
