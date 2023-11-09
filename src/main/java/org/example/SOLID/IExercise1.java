package org.example.SOLID;

public class IExercise1 {
    public interface Person {
        void study();
        void work();
        void play();
    }
    public static class Student implements Person {
        @Override
        public void study() {
            System.out.println("Student is studying.");
        }

        @Override
        public void work() {
        }

        @Override
        public void play() {
        }
    }

    public static class Worker implements Person {
        @Override
        public void study() {
        }

        @Override
        public void work() {
            System.out.println("Worker is working.");
        }

        @Override
        public void play() {
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        Student student = new Student();
        worker.work();
        worker.play();
        worker.study();
        student.work();
        student.play();
        student.study();
    }

}
