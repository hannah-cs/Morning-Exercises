package org.example;
import java.util.*;
import java.util.stream.*;
public class Exercises {
    public static void main(String[] args) {
        // exercise 1
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 1);
        List<Integer> even = number.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Exercise 1:");
        System.out.println(even);
        //bonus
        int sumEven = even.stream()
                .reduce(0, (a,b)->a+b);
        System.out.println("Exercise 1 bonus:");
        System.out.println(sumEven);

        // exercise 2
        List<String> words = Arrays.asList("hello", "world", "streams", "java");
        List<String> upperCase = words.stream()
                .map(name->name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Exercise 2:");
        System.out.println(upperCase);
        //bonus
        int charCount = words.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Exercise 2 bonus:");
        System.out.println(charCount);


        // exercise 3
        List<Integer> numbersToSum = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbersToSum.stream()
                .reduce(0, (a,b)->a+b);
        System.out.println("Exercise 3:");
        System.out.println(sum);
        //bonus
        int avg = sum / numbersToSum.size();
        System.out.println("Exercise 3 bonus:");
        System.out.println(avg);


        // exercise 4
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
        String singleString = fruits.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Exercise 4:");
        System.out.println(singleString);
        //bonus
        Collections.reverse(fruits);
        String fruitsReverse = fruits.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Exercise 4 bonus:");
        System.out.println(fruitsReverse);


        // exercise 5
        List<String> animals = Arrays.asList("cat", "elephant", "dog", "dolphin");
        List<String> animals3 = animals.stream()
                .filter(x -> x.length()>3)
                .collect(Collectors.toList());
        System.out.println("Exercise 5:");
        System.out.println(animals3);
        //bonus
        String min = animals.stream()
                .min((a, b) -> Integer.compare(a.length(), b.length()))
                .orElse(null);
        System.out.println("Exercise 5 bonus:");
        System.out.println(min);

    }
}
