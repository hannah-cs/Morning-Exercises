package org.example.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise4 {
    public class Task1 implements Runnable {
        @Override
        public void run() {
            System.out.println("Task 1");
        }
    }
    public class Task2 implements Runnable {
        @Override
        public void run() {
            System.out.println("Task 2");
        }
    }

    public static void main(String[] args) {
        Exercise4 exercise = new Exercise4();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(exercise.new Task1());
        executor.submit(exercise.new Task2());
        executor.shutdown();
    }
}

