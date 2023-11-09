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

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.makeSound();
        cat.makeSound();
    }
}
