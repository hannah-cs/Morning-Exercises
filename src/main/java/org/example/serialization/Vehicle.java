package org.example.serialization;

import java.io.*;

public class Vehicle implements Externalizable {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Vehicle(){

    }
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(make);
        out.writeObject(model);
        out.writeInt(year);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        make = (String) in.readObject();
        model = (String) in.readObject();
        year = in.readInt();
    }

    @Override
    public String toString() {
        return "Vehicle{" + "make='" + make +", model='" + model +", year=" + year +'}';
    }

    public static void serializeVehicle(Vehicle vehicle, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(vehicle);
            System.out.println("Vehicle object serialized to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Vehicle deserializeVehicle(String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Vehicle deserializedVehicle = (Vehicle) objectIn.readObject();
            System.out.println("Vehicle object deserialized from " + fileName);
            return deserializedVehicle;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Volkswagen", "Beetle", 1963);
        String fileName = "vehicle.ser";
        serializeVehicle(vehicle, fileName);
        System.out.println("Original Vehicle: " + vehicle);
        Vehicle deserializedVehicle = deserializeVehicle(fileName);
        System.out.println("Deserialized Vehicle: " + deserializedVehicle);
    }
}
