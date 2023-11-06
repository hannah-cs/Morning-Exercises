package org.example.Threads;

public class IE3 {
    public static void main(String[] args) {
        Thread teacherThread = new Thread(() -> {
            System.out.println("Teacher is lecturing...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.err.println("Teacher was interrupted while lecturing.");
            }
            System.out.println("Teacher has finished the lecture.");
        });

        Thread studentThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                teacherThread.interrupt();
            } catch (InterruptedException e) {
                System.err.println("Student was interrupted while waiting.");
            }
        });

        teacherThread.start();
        studentThread.start();
    }
}

