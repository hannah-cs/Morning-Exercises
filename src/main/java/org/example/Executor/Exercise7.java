package org.example.Executor;
import java.util.concurrent.*;

public class Exercise7 {
        public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(1);
            Future<Integer> future = executor.submit(() -> {
                Thread.sleep(2000);
                return 7639 * 8924;
            });
            if (!future.isDone()) {
                System.out.println("Processing...");
            }
            try {
                int result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            executor.shutdown();
        }
    }