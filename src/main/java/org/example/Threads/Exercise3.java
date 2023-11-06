package org.example.Threads;

public class Exercise3 implements Runnable {
    public void run() {
        while (true) {
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Thread numberThread = new Thread(new Exercise3());
        numberThread.start();
    }
}