package multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// Recursive Task: Calculate the sum of numbers from 1 to n using ForkJoinPool
public class RecursiveSumTask {
    public static void main(String[] args) {
        int n = 10000; // Change this value to test with different numbers
        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(new SumTask(1, n));
        System.out.println("Sum from 1 to " + n + " is: " + result);
    }

    static class SumTask extends RecursiveTask<Integer> {
        private final int start;
        private final int end;

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= 2) {
                return sum(start, end);
            } else {
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(start, mid);
                SumTask rightTask = new SumTask(mid, end);
                leftTask.fork();
                return rightTask.compute() + leftTask.join();
            }
        }

        private int sum(int start, int end) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
