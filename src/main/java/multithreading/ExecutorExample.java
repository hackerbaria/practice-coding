package multithreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Basic Task: Run 5 tasks concurrently using ExecutorService
public class ExecutorExample {

    public static void main(String[] args) {
        // Create a thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit 5 tasks to the executor
        for (int i = 0; i < 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is running");
                try {
                    Thread.sleep(2000); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " is completed");
            });
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
