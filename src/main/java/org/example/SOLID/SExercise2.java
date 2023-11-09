package org.example.SOLID;
import java.util.ArrayList;
import java.util.List;
public class SExercise2 {
    public static List <Grade> allGrades = new ArrayList<>();
    public static class Grade {
        String subject;
        char letterGrade;
        public Grade(String subject) {
            this.subject = subject;
            allGrades.add(this);
        }

        public void calcGrade(int percentage) {
            if (percentage >= 85 && percentage <= 100) {
                letterGrade = 'A';
            } else if (percentage < 85 && percentage >= 70) {
                letterGrade = 'B';
            } else if (percentage < 70 && percentage >= 55) {
                letterGrade = 'C';
            } else if (percentage < 55 && percentage >= 40) {
                letterGrade = 'D';
            } else if (percentage < 40 && percentage >= 25) {
                letterGrade = 'E';
            } else {
                letterGrade = 'F';
            }
            System.out.println("Student scored "+percentage+"%. Grade: "+letterGrade);
        }
    }
    public static class ReportCard {
        public void printReport() {
            System.out.println("Report card:");
            for (Grade grade : allGrades){
                System.out.println("Subject: "+grade.subject+", grade: "+grade.letterGrade);
            }
        }
    }
    public static void main(String[] args) {
        Grade java = new Grade("Java");
        Grade solid = new Grade("Solid principles");
        java.calcGrade(87);
        solid.calcGrade(56);
        ReportCard reportCard = new ReportCard();
        reportCard.printReport();
    }
}
