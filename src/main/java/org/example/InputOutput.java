package org.example;
import java.util.Scanner;
import java.io.*;

public class InputOutput {
    public static void main(String[] args) {
        // exercise 1
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string:");
        String input = sc.nextLine();
        System.out.println("You entered: "+input);

        // exercise 2
        Scanner sc2 = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = sc2.nextLine();
        System.out.println("Nice to meet you, "+name+"!");

        //exercise 3
        try {
            FileWriter writer = new FileWriter("input.txt");
            writer.write("Hello world");
            writer.close();
            System.out.println("Successfully created input.txt");
            FileReader fileReader = new FileReader("input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter outputWriter = new FileWriter("output.txt");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outputWriter.write(line + "\n");
            }
            fileReader.close();
            bufferedReader.close();
            outputWriter.close();
            System.out.println("Successfully copied contents of input.txt to output.txt");
            FileReader outputReader = new FileReader("output.txt");
            BufferedReader outputBufferedReader = new BufferedReader(outputReader);
            System.out.println("Contents of 'output.txt':");
            while ((line = outputBufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            outputReader.close();
            outputBufferedReader.close();
            } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
            }

        //exercise 4
        String sourceFileName = "source.txt";
        String destinationFileName = "destination.txt";

        try {
            FileWriter ex4 = new FileWriter("source.txt");
            FileInputStream in = new FileInputStream(sourceFileName);
            FileOutputStream out = new FileOutputStream(destinationFileName);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            in.close();
            out.close();
            System.out.println("File copied successfully from " + sourceFileName + " to " + destinationFileName);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        //exercise 5
        String csvFileName = "data.csv";

        try {
            FileWriter ex5 = new FileWriter("data.csv");
            BufferedReader reader = new BufferedReader(new FileReader(csvFileName));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + "\t");
                }
                System.out.println();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
