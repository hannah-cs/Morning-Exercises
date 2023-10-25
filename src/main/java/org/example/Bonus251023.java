package org.example;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Bonus251023 {
    public static void main(String[] args) {
        // exercise 1
        ArrayList<String> uniqueWords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter text (or 'Export' to save and exit): ");
            String userInput = scanner.nextLine();
            String[] words = userInput.split("\\s");
            for (String word : words) {
                if (!word.isEmpty() && !uniqueWords.contains(word)) {
                    uniqueWords.add(word);
                }
            }
            if (userInput.equalsIgnoreCase("Export")) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
                    for (String word : uniqueWords) {
                        writer.write(word + " ");
                    }
                    writer.close();
                    System.out.println("Unique words saved to 'output.txt'");
                } catch (IOException e) {
                    System.err.println("An error occurred while saving unique words to 'output.txt': " + e.getMessage());
                }
                break;
            }
        }
        scanner.close();

        // exercise 2
        try {
            FileReader fileReader = new FileReader("input_numbers.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int lineCount = 0;
            while (bufferedReader.readLine() != null) {
                lineCount++;
            }
            fileReader.close();
            bufferedReader.close();
            System.out.println("Line count: " + lineCount);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        // exercise 3
        try {
            FileReader newReader = new FileReader("input.txt");
            BufferedReader bufferedReader = new BufferedReader(newReader);
            FileWriter outputWriter = new FileWriter("to_uppercase.txt");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outputWriter.write(line.toUpperCase() + "\n");
            }
            newReader.close();
            bufferedReader.close();
            outputWriter.close();
            System.out.println("Successfully copied contents of input.txt to to_uppercase.txt");
            FileReader outputReader = new FileReader("to_uppercase.txt");
            BufferedReader outputBufferedReader = new BufferedReader(outputReader);
            System.out.println("Contents of 'to_uppercase.txt':");
            while ((line = outputBufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            outputReader.close();
            outputBufferedReader.close();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}