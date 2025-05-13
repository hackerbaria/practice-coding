package multithreading;


// You are given 10 files (simulated), and each file takes 1 second to process. Use a FixedThreadPool to process them concurrently.
public class FileProcessingSimulation {
    public static void main(String[] args) {
        // Create a thread pool with 5 threads
        java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(5);

        // Simulate processing 10 files
        for (int i = 1; i <= 10; i++) {
            int fileId = i;
            executor.submit(() -> {
                System.out.println("Processing file " + fileId);
                try {
                    Thread.sleep(1000); // Simulate file processing time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("File " + fileId + " processed");
            });
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
