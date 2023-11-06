package org.example.Threads;
public class Exercise1 implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Thread numberThread = new Thread(new Exercise1());
        numberThread.start();
    }
}
