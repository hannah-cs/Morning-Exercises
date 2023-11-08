package org.example.Executor;
import java.util.concurrent.*;

public class Exercise5 {
    private ScheduledExecutorService executorService;
    public Exercise5() {
        executorService = Executors.newSingleThreadScheduledExecutor();
    }
    public void execute() {
        executorService.schedule(() -> {
            System.out.println("I'm scheduled!");
        }, 2, TimeUnit.SECONDS);
    }
    public static void main(String[] args) {
        Exercise5 exercise = new Exercise5();
        exercise.execute();
        ScheduledExecutorService periodicExecutor = Executors.newScheduledThreadPool(1);
        periodicExecutor.scheduleAtFixedRate(() -> {
        }, 1, 10, TimeUnit.SECONDS);

        periodicExecutor.scheduleWithFixedDelay(() -> {
        }, 1, 10, TimeUnit.SECONDS);
        exercise.executorService.shutdown();
        periodicExecutor.shutdown();
    }
}
