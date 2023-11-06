package org.example.Threads;

public class Daemon2 {
    public static void main(String[] args) {
        Thread mainThread = new Thread(() -> {
            while (true) {
                System.out.println("Main task running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread backgroundThread = new Thread(() -> {
            while (true) {
                System.out.println("Background task running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        backgroundThread.setDaemon(true);
        mainThread.start();
        backgroundThread.start();
    }
}
