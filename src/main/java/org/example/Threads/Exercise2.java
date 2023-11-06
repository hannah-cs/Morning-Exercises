package org.example.Threads;

public class Exercise2 {
    public static class Thread1 extends Thread {

        public void run() {
            for (int i = 1; i <= 10; i++) {
                if (i%2 != 0) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Thread2 extends Thread {

        public void run() {
            for (int i = 1; i <= 10; i++) {
                if (i%2 == 0) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
}