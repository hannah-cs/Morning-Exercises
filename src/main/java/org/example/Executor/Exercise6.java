package org.example.Executor;
import java.util.concurrent.*;

public class Exercise6 {
    private ScheduledExecutorService executorService;

    public Exercise6() {
        executorService = Executors.newSingleThreadScheduledExecutor();
    }
    public void execute() {
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Repeating task");
        }, 0, 1, TimeUnit.SECONDS);
    }
    public static void main(String[] args) {
        Exercise6 exercise = new Exercise6();
        exercise.execute();
    }
}
