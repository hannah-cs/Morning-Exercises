package org.example.Threads;

public class Runnable3 implements Runnable {
    private int[] numbers;
    public Runnable3(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum of the numbers: " + sum);
    }
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Runnable3 sumCalculator = new Runnable3(numbers);
        Thread thread = new Thread(sumCalculator);
        thread.start();
    }
}
