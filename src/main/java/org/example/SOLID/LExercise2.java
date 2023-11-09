package org.example.SOLID;

public class LExercise2 {
    public static class Student {
        String level;
        public void study(){
            System.out.println("Student studied "+level+" level materials.");
        }
    }

    public static class Undergraduate extends Student {
        public Undergraduate(){
            this.level = "undergraduate";
        }
    }
    public static class Graduate extends Student {
        public Graduate(){
            this.level = "graduate";
        }
    }

    public static void main(String[] args) {
        Student undergrad = new Undergraduate();
        Student grad = new Graduate();
        undergrad.study();
        grad.study();
    }
}
