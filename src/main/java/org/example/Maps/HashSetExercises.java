package org.example.Maps;
import java.util.HashSet;

public class HashSetExercises {
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
    }
}