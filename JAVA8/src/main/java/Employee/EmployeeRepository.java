package Employee;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeRepository {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 60000, "IT", 30),
                new Employee("Bob", 75000, "HR", 35),
                new Employee("Charlie", 80000, "Finance", 28),
                new Employee("Diana", 55000, "Marketing", 32),
                new Employee("Eve", 95000, "IT", 29),
                new Employee("Frank", 70000, "Operations", 40)
        );

        // Create an instance of EmployeeRepository
        EmployeeRepository repository = new EmployeeRepository();

        // Filter employees with salary > 50,000 and print the result
        Map<String, Double> filteredEmployees = repository.filterEmployeeMoreThanFiftyThousand(employees);
        if (filteredEmployees.isEmpty()) {
            System.out.println("No employees found with salary greater than 50,000.");
        } else {
            filteredEmployees.forEach((name, salary) -> 
                    System.out.println("Name: " + name + ", Salary: " + salary));
        }

        // Perform the parallel computation for square sums
        repository.calculateParallelSum();
    }

    // Method to filter employees with salary greater than 50,000
    public Map<String, Double> filterEmployeeMoreThanFiftyThousand(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.getSalary() > 50000) // Filter employees with salary > 50,000
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary)); // Collect into a Map
    }

    // Method to calculate the parallel sum of squares of numbers
    public void calculateParallelSum() {
        // Generate a list of numbers
        List<Integer> numbers = IntStream.range(1, 10_000_000)
                .boxed()
                .collect(Collectors.toList());

        // Record the start time
        Instant start = Instant.now();

        // Calculate the sum of squares in parallel
        long parallelSum = numbers.parallelStream()
                .mapToLong(n -> (long) n * n) // Compute the square of each number
                .sum();

        // Record the end time
        Instant end = Instant.now();

        // Print the sum and execution time
       System.out.println("Parallel sum: " + parallelSum);
        System.out.println("Execution time: " + (end.toEpochMilli() - start.toEpochMilli()) + "ms");
    }
}
