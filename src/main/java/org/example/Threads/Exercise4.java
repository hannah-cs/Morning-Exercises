package org.example.Threads;

public class Exercise4 implements Runnable {
    public void run() {
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Thread numberThread = new Thread(new Exercise4());
        numberThread.start();
    }
}
