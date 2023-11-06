package org.example.Threads;

public class IE4 {
    public static void main(String[] args) {
        Thread downloadThread = new Thread(() -> {
            System.out.println("Downloading file...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.err.println("Download cancelled.");
            }
            System.out.println("File not downloaded.");
        });

        Thread interruptThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                downloadThread.interrupt();
            } catch (InterruptedException e) {
                System.err.println("Cancel not succefssful.");
            }
        });

        downloadThread.start();
        interruptThread.start();
    }
}

