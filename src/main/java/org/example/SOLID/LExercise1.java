package org.example.SOLID;

public class LExercise1 {
    public static class Bird {
        String species;
        public void fly(){
            System.out.println(species+" flew away.");
        }
    }
    public static class Pigeon extends Bird {
        public Pigeon(){
            this.species = "pigeon";
        }
    }

    public static class Sparrow extends Bird {
        public Sparrow(){
            this.species = "sparrow";
        }
    }

    public static void main(String[] args) {
        Bird pigeon = new Pigeon();
        Bird sparrow = new Sparrow();
        pigeon.fly();
        sparrow.fly();
    }
}
