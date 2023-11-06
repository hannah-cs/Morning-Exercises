package org.example.Threads;

public class Daemon3 {
    public static void main(String[] args) {
        Thread mainThread = new Thread(() -> {
            while (true) {
                System.out.println("*");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread backgroundThread = new Thread(() -> {
            while (true) {
                System.out.println("Cleaning up resources");
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
