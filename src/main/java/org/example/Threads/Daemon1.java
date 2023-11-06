package org.example.Threads;

public class Daemon1 {
        public static void main(String[] args) {
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
            backgroundThread.start();
            System.out.println("Main thread is done.");
        }
    }
