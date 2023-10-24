package org.example;

import java.io.*;
import java.util.Scanner;

public class Bonus231023 {
    public static void main(String[] args) {
        // exercise 1
        try {
            FileWriter writer = new FileWriter("input.txt");
            writer.write("Hello, my name is Hannah.");
            writer.close();
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
            if ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                int wordCount = words.length;
                System.out.println("Total number of words in the file: " + wordCount);
            } else {
                System.out.println("The file is empty.");
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        //exercise 2
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your text. Type 'Exit' to quit.");
        StringBuilder inputBuilder = new StringBuilder();
        while (true) {
            String input = userInput.nextLine();
            if (input.equalsIgnoreCase("Exit")) {
                System.out.println("Scanner closed.");
                break;
            }
            inputBuilder.append(input).append("\n");
        }
        userInput.close();
        String userInputText = inputBuilder.toString();
        System.out.println("You entered:\n" + userInputText);


        // exercise 3
        try {
            FileWriter writer = new FileWriter("existingFile.txt", true);
            Scanner fileInput = new Scanner(System.in);
            System.out.println("Enter text to append to the file (type 'Exit' to quit):");
            String input;
            while (true) {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                input = br.readLine();
                if (input.equalsIgnoreCase("Exit")) {
                    System.out.println("File append complete.");
                    break;
                }
                writer.write(input + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
