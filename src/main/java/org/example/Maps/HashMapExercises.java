package org.example.Maps;
import java.util.Map;
import java.util.HashMap;

public class HashMapExercises {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();

        students.put(1, "Hannah");
        students.put(2, "Faruk");
        students.put(3, "Menil");

        String student1Name = students.get(1);
        System.out.println("Student 1: " + student1Name);
    }
}