package org.example.Maps;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetExercises {

    public static class Person implements Comparable<Person>{
        String name;
        int age;
        public Person(String name, int age){
            this.name=name;
            this.age=age;
        }

        @Override
        public int compareTo(Person otherPerson) {
            return Integer.compare(this.age, otherPerson.age);
        }

        @Override
        public String toString(){
            return name+" - aged "+age+"";
        }
    }

    public static void main(String[] args) {
        HashSet<Integer> integerSet = new HashSet();
        integerSet.add(17);
        integerSet.add(32);
        integerSet.add(56);
        integerSet.add(4);
        integerSet.add(17);

        for (Integer element : integerSet){
            System.out.println(element);
        }



        HashSet<String> uniqueStrings = new HashSet();
        String[] strings = new String[]{"apple", "banana", "apple", "cherry"};
        for (String string : strings) {
            uniqueStrings.add(string);
        }
        System.out.println(uniqueStrings);



        TreeSet<Integer> sortedSet = new TreeSet();
        sortedSet.add(45);
        sortedSet.add(57);
        sortedSet.add(82);
        sortedSet.add(12);

        System.out.println(sortedSet);
        for (int element : sortedSet){
            System.out.println(element);
        }

        TreeSet<Person> personSet = new TreeSet();
        personSet.add(new Person("Bob", 45));
        personSet.add(new Person("Jane", 28));
        personSet.add(new Person("Jim", 16));

        System.out.println(personSet);
    }
}