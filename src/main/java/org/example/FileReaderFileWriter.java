package org.example;

import java.io.*;
import java.util.*;

public class FileReaderFileWriter {
    public static void main(String[] args) {
        // exercise1
        try {
            FileReader fileReader = new FileReader("input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line + "\n");
            }
            fileReader.close();
            bufferedReader.close();
        } catch (
                IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        // exercise2
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write("Hello world");
            writer.close();
            System.out.println("Successfully wrote to file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

        // exercise3 + 4
        try {
            FileReader reader = new FileReader("source.txt");
            FileWriter writer = new FileWriter("destination.txt", true);
            char[] buffer = new char[500];
            int charsRead;
            while ((charsRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, charsRead);
            }
            reader.close();
            writer.close();
            System.out.println("Text appended to destination.txt");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        // exercise5
        try {
            FileReader intReader = new FileReader("input_numbers.txt");
            BufferedReader reader = new BufferedReader(intReader);
            String line;
            List<Integer> integerList = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] ints = line.split(" ");
                for (String element : ints) {
                    int num = Integer.parseInt(element);
                    integerList.add(num);
                }
            }
            intReader.close();
            reader.close();
            int sum = 0;
            for (int num : integerList) {
                sum += num;
            }
            FileWriter intWriter = new FileWriter("output_sum.txt");
            intWriter.write(sum);
            intWriter.close();
            System.out.println("Successfully wrote sum "+sum+" to file output_sum.txt");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
