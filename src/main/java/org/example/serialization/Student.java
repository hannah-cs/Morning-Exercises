package org.example.serialization;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private String name;
    private int id;
    private double grade;
    List<Student> students = new ArrayList<>();
    private static String fileName = "students_array.ser";
    private static String fileName2 = "fake_path.ser";

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public static void serializeStudents(List<Student> students) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(students);
            System.out.println("Student array serialized to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> deserializeStudents() {
        try (FileInputStream fileIn = new FileInputStream(fileName2);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            List<Student> deserializedStudents = (List<Student>) objectIn.readObject();
            System.out.println("Student array deserialized from " + fileName2);
            return deserializedStudents;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Hannah", 123, 2.5);
        Student student2 = new Student("Faruk", 321, 1.2);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        serializeStudents(students);
        deserializeStudents();
    }
}