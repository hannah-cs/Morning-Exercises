package org.example.Threads;

public class IE1 {
    public static void main(String[] args) {
            Thread sleeperThread = new Thread(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Awake");
                } catch (InterruptedException e) {
                    System.err.println("Thread was interrupted");
                }
            });
            sleeperThread.start();
        }
    }
