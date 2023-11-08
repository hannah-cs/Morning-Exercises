package org.example.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise3 {
    public class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Executor service in action!");
        }
    }

    public static void main(String[] args) {
        Exercise3 exercise = new Exercise3();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(exercise.new Task());
        executor.shutdown();
    }
}

