package org.example;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // square
        List<Integer> number = Arrays.asList(2,3,4,5);
        List<Integer> square = number.stream()
                .map(x->x*x)
                .collect(Collectors.toList());
        System.out.println(square);

        // filter
        List<String> names = Arrays.asList("Hannah", "Nev", "Rosa", "Miro");
        List<String> result = names.stream()
                .filter(a -> a.contains("a"))
                .collect(Collectors.toList());
        System.out.println(result);

        // sorted
        List<String> alphabetised
                = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(alphabetised);



        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);

        // return a set
        Set<Integer> squareSet
                = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toSet());
        System.out.println(squareSet);

        // for each
        number.stream()
                .map(x -> x * x)
                .forEach(y -> System.out.println(y));

        // reduce
        int even
                = number.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, (ans, i) -> ans + i);

        System.out.println(even);

    }
}