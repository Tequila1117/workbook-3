package com.pluralsight.stories; // Package declaration

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class BedtimeStories { // Class definition
    public static void main(String[] args) {
        // Make a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Show the menu options to the user
        System.out.println("Select a story to read:");
        System.out.println("1. goldilocks.txt");
        System.out.println("2. hansel_and_gretel.txt");
        System.out.println("3. mary_had_a_little_lamb");
        System.out.print("Enter your choice (1, 2, or 3): ");

        int choice = scanner.nextInt(); // Read the user's choice
        scanner.nextLine();
        String storyName = "";

        // Determine the story name based on the user's choice using if-else
        if (choice == 1) {
            storyName = "goldilocks";
        } else if (choice == 2) {
            storyName = "hansel_and_gretel";
        } else if (choice == 3) {
            storyName = "mary_had_a_little_lamb";
        } else {
            System.out.println("Invalid choice. Exiting.");
            scanner.close();
            return; // Exit if user input is not correct
        }

        String filePath = "C:\\pluralsight\\workbook-3\\bedtime-stories\\src\\main\\resources\\DataFiles\\" + storyName + ".txt";

        // Try to read the file and display what is within that file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1; // Initialize line number

            // Read each line of the file
            while ((line = reader.readLine()) != null) {
                // Print the line with its line number
                System.out.println(lineNumber + ": " + line);
                lineNumber++; // Increment line number
            }
        } catch (IOException e) {
            // Address possible IOExceptions (like file not found)
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}