package multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AsyncApiSimulation {

    // Simulate fetching user from DB
    public static CompletableFuture<String> fetchUser() {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay("Fetching user...");
            return "user123";
        });
    }

    // Simulate fetching orders by user ID
    public static CompletableFuture<List<Integer>> fetchOrders(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay("Fetching orders for " + userId);
            return Arrays.asList(100, 200, 50); // order totals
        });
    }

    // Simulate calculating total from orders
    public static CompletableFuture<Integer> calculateTotal(List<Integer> orders) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay("Calculating total...");
            return orders.stream().mapToInt(Integer::intValue).sum();
        });
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> orderFlow = fetchUser()
                .thenCompose(AsyncApiSimulation::fetchOrders)
                .thenCompose(AsyncApiSimulation::calculateTotal)
                .exceptionally(ex -> {
                    System.out.println("❌ Error: " + ex.getMessage());
                    return -1;
                });

        System.out.println("Total order amount: " + orderFlow.join());
    }



    private static void simulateDelay(String message) {
        System.out.println("🕒 " + message + " on thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
