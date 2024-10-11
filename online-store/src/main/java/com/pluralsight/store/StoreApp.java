package com.pluralsight.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class for the Online Store application
public class StoreApp {
    private static List<Products> productList = new ArrayList<>(); // List to hold products
    private static Scanner scanner = new Scanner(System.in); // For user input
    private static Cart cart = new Cart(); // User's shopping cart

    public static void main(String[] args) {
        loadProducts("C:\\pluralsight\\workbook-3\\online-store\\src\\main\\resources\\products.csv"); // Load products from file
        showMainMenu(); // Start the main menu loop

        // Example of creating a new product directly
        Products p = new Products("AV9999", "New Product", 29.99, "Electronics");
        productList.add(p); // Add the new product to the product list

        scanner.close(); // Close scanner
    }

    // Load products from the CSV file
    private static void loadProducts(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line to extract product details
                String[] parts = line.split("\\|"); // Split the line by "|"

                