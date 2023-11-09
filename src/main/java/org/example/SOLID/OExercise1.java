package org.example.SOLID;

public class OExercise1 {
    public static class Animal {
        String sound;
        String animalName;

        public void makeSound() {
            System.out.println("The " + animalName + " made a " + sound + " sound.");
        }
    }

        public static class Dog extends Animal {
            public Dog() {
                sound = "bark";
                animalName = "dog";
            }
        }

        public static class Cat extends Animal {
            public Cat() {
                sound = "meow";
                animalName = "cat";
            }
        }

    public static class Frog extends Animal {
        public Frog() {
            sound = "ribbit";
            animalName = "frog";
        }
    }
    public static class Horse extends Animal {
        public Horse() {
            sound = "neigh";
            animalName = "horse";
        }
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal frog = new Frog();
        Animal horse = new Horse();
        dog.makeSound();
        cat.makeSound();
        frog.makeSound();
        horse.makeSound();
    }
}
