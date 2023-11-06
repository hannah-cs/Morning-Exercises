package org.example.Threads;
public class Runnable1 implements Runnable {
        @Override
        public void run() {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                System.out.print(ch + " ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) {
            Thread alphabetThread = new Thread(new Runnable1());
            alphabetThread.start();
        }
}