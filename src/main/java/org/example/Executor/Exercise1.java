package org.example.Executor;
import java.util.concurrent.Executor;

public class Exercise1 {
    public static class Invoker implements Executor {
        @Override
        public void execute(Runnable r) {
            r.run();
        }
    }
    public void execute() {
        Executor executor = new Invoker();
        executor.execute(() -> {
            System.out.println("Hello from executor");
        });
    }
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.execute(() -> {
            System.out.println("Hello from executor");
        });
    }
}
