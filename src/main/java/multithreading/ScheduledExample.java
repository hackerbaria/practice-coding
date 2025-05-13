package multithreading;

// Task: print "Hello, World!" every 2 seconds using ScheduledExecutorService
public class ScheduledExample {
    public static void main(String[] args) {
        // Create a ScheduledExecutorService with a single thread
        java.util.concurrent.ScheduledExecutorService scheduler = java.util.concurrent.Executors.newScheduledThreadPool(1);

        // Schedule a task to run every 2 seconds
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Hello, World!");
        }, 0, 2, java.util.concurrent.TimeUnit.SECONDS);

        // Keep the main thread alive for 10 seconds to see the scheduled task in action
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Shutdown the scheduler
        scheduler.shutdown();
    }
}
