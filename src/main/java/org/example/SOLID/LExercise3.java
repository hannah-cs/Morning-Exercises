package org.example.SOLID;

public class LExercise3 {
    public static class Vehicle{
        String type;
        public void startEngine(){
            System.out.println("The "+type+" started its engine and drove away.");
        }
    }

    public static class Car extends Vehicle{
        public Car(){
            this.type = "car";
        }
    }

    public static class Bicycle extends Vehicle{
        public Bicycle(){
            this.type = "bicycle";
        }
        @Override
        public void startEngine(){
            System.out.println("A "+type+" does not have an engine.");
        }
    }

    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bicycle();
        car.startEngine();
        bike.startEngine();
    }
}
