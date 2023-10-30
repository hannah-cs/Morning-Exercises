package org.example.Maps;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;

public class HashMapExercises {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();

        students.put(1, "Hannah");
        students.put(2, "Faruk");
        students.put(3, "Menil");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            int studentID = entry.getKey();
            String studentName = entry.getValue();
            System.out.println("Student ID: " + studentID + ", student name: " + studentName);
        }

        Map<String, String> capitals = new LinkedHashMap<>();
        capitals.put("Germany", "Berlin");
        capitals.put("Ireland", "Dublin");
        capitals.put("Turkey", "Ankara");

        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            String country = entry.getKey();
            String capital = entry.getValue();
            System.out.println("Country: "+country+", capital city: "+capital);
        }

        System.out.println(students.get(1));
        students.remove(1);
        System.out.println(students.get(1));
    }
}