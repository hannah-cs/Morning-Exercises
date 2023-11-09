package org.example.SOLID;
public class SExercise1 {
    public static class DogSound {
        public void makeSound(int volume) {
            System.out.println("Dog barked at " + volume + " decibels.");
        }
    }
    public static class DogEat {
        public void eatFood(String food) {
            System.out.println("Dog ate some " + food);
        }
    }
    public static void main(String[] args) {
        DogSound dogSound = new DogSound();
        DogEat dogEat = new DogEat();
        dogSound.makeSound(14);
        dogEat.eatFood("dog food");
    }
}
