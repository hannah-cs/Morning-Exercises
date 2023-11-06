package org.example.Threads;
public class Runnable2 {
    public static class Cooking extends Thread {
        public void run() {
            System.out.println("Boil water");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Add pasta");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Chop tomatoes");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Chop onions");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Cook tomatoes & onions into sauce");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Season sauce");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Add pasta to sauce");
        }
    }
    public static class Eating extends Thread {

        public void run() {
            System.out.println("Get cutlery");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Enjoy pasta");
        }
    }

    public static void main(String[] args) {
        new Runnable2.Cooking().start();
        new Runnable2.Eating().start();
    }
}
