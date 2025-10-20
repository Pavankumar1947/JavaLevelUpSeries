package JavaLevelUpSeries;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadDemo {
	public static void main(String[] args) {
        // Create a virtual-thread-based executor
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        try (executor) {
            for (int i = 1; i <= 100_000; i++) {
                int taskId = i;
                executor.submit(() -> {
                    // Simulating an I/O task
                    System.out.println("Running task " + taskId + " on " + Thread.currentThread());
                });
            }
        }
    }

}
