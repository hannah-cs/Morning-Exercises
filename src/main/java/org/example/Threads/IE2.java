package org.example.Threads;

public class IE2 {
    public static void main(String[] args) {
        Thread longTaskThread = new Thread(() -> {
            longTask();
        });
        longTaskThread.start();
        Thread interruptingThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                longTaskThread.interrupt();
            } catch (InterruptedException e) {
                System.err.println("Interrupting thread was interrupted");
            }
        });
        interruptingThread.start();
    }
    private static void longTask() {
        long largeNumber = 999999302;
        for (long i = 0; i < largeNumber; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Long task interrupted");
                return;
            }
        }
        System.out.println("Long task completed");
    }
}

