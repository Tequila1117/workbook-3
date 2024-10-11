package com.pluralsight.calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Array

public class PayrollCalculator {
    public static void main(String[] args) {
        // Declare a FileReader object directly


        try {
            // Initialize FileReader with the path to the CSV file
            FileReader fileReader = new FileReader("./src/main/resources/DataFiles/employees.csv");
            // Use BufferedReader to read from the FileReader
            BufferedReader br = new BufferedReader(fileReader);

            String line; // Variable to hold each line of the file
            br.readLine(); // reads the line of text

            // Read each line of the file until there are no more lines
            while ((line = br.readLine()) != null) {
                // Split the line into parts using the '|' delimiter
                String[] tokens = line.split("\\|");

                // Parse data from tokens and create a new Employee object
                int employeeId = Integer.parseInt(tokens[0]); // Convert first token to integer
                String name = tokens[1]; // Second token is the name
                double hoursWorked = Double.parseDouble(tokens[2]); // Convert third token to double
                double payRate = Double.parseDouble(tokens[3]); // Convert fourth token to double

                // Create an Employee object using the parsed data
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
                // Display employee information
                System.out.printf("Employee ID: %d, Name: %s, Gross Pay: %.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }


        } catch (Exception e) {
            // Print error message if there's an issue reading the file
           throw new RuntimeException(e);
        }
    }
}

