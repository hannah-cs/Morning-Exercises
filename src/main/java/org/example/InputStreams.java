package org.example;
import java.io.*;

public class InputStreams {
    public static void main(String[] args) {

        // exercise 1
        try {
            FileWriter writer = new FileWriter("input.txt");
            writer.write("Hello world");
            writer.close();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        try {
            FileInputStream inputStream = new FileInputStream("input.txt");
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {  //exercise 2
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        // exercise 3
        try {
            FileInputStream imageStream = new FileInputStream("image.jpg");
            int data;
            while ((data = imageStream.read()) != -1) {
                System.out.println(data + " ");
            }
            imageStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // exercise 4
        try {
            FileInputStream sourceInput = new FileInputStream("image.jpg");
            FileOutputStream destinationOutput = new FileOutputStream("copy_image.jpg");
            int data;
            while ((data = sourceInput.read()) != -1) {
                destinationOutput.write(data);
            }
            sourceInput.close();
            destinationOutput.close();
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // exercise 5
        try {
            FileInputStream csvInput = new FileInputStream("data.csv");
            InputStreamReader csvReader = new InputStreamReader(csvInput);
            BufferedReader reader = new BufferedReader(csvReader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + "\t\t");
                }
                System.out.println();
            }
            reader.close();
            csvReader.close();
            csvInput.close();
        } catch (IOException e) {  // exercise 6
            e.printStackTrace();
        }

        // exercise 7
        int bufferSize = 1000;
        long startTime = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new FileReader("large_data.txt"), bufferSize)) {
            char[] buffer = new char[bufferSize];
            int charsRead;
            while ((charsRead = reader.read(buffer, 0, bufferSize)) != -1) {
                System.out.print(new String(buffer, 0, charsRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println(" ");
        System.out.println("___");
        System.out.println("Time taken to read the file: " + elapsedTime + " milliseconds");
    }
}