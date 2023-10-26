package org.example.serialization;

import java.io.*;
import java.time.LocalDateTime;
public class Person implements Serializable {
    private String name;
    private int age;
    private String address;
    private transient LocalDateTime currentDateTime;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.currentDateTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name +", age=" + age + ", address='" + address + "' current datetime=" + currentDateTime + '}';
    }

    public static void serializePerson(Person person, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(person);
            System.out.println("Person object serialized to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person deserializePerson(String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Person deserializedPerson = (Person) objectIn.readObject();
            System.out.println("Person object deserialized from " + fileName);
            return deserializedPerson;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
        String encryptedName = new StringBuilder(name).reverse().toString();
        stream.defaultWriteObject();
        stream.writeObject(encryptedName);
    }

    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        String encryptedName = (String) stream.readObject();
        name = new StringBuilder(encryptedName).reverse().toString();
    }

    public static void main(String[] args) {
        Person person = new Person("Hannah CS", 31, "Berlin 1");
        serializePerson(person, "person.ser");
        Person deserializedPerson = deserializePerson("person.ser");
        System.out.println("Original person details: "+person);
        System.out.println("Deserialized Person Details: " + deserializedPerson);
    }
}