package com.pluralsight.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class for the Online Store application
public class StoreApp {
    private List<Products> productList; // List to hold all products
    private List<Products> cart; // List to hold products in the cart
    private Scanner scanner;

    // Constructor to initialize the application
    public StoreApp() {
        productList = new ArrayList<>();
        cart = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadProducts(); // Load products from CSV file
    }

    // Method to load products from the products.csv file
    private void loadProducts() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\pluralsight\\workbook-3\\online-store\\src\\main\\resources\\products.csv"))) {
            // Skip the header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\|"); // Split the line by '|'
                if (values.length == 4) {
                    String sku = values[0];
                    String name = values[1];
                    double price = Double.parseDouble(values[2]);
                    String department = values[3];
                    productList.add(new Products(sku, name, price, department)); // Add product to list
                }
            }
        } catch (IOException e) {
            System.out.println("Sorry, there was an error loading the products: " + e.getMessage());
        }
    }

    // Method to display the main menu
    private void displayMenu() {
        while (true) {
            System.out.println("Store Home Screen");
            System.out.println("1. Show Products");
            System.out.println("2. Show Shopping Cart");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    displayCart();
                    break;
                case 3:
                    System.out.println("Thank you for shopping!");
                    return; // Exit the application
                default:
                    System.out.println("Input is not valid. Please try again.");
            }
        }
    }

    // Method to show products and handle search and add to cart
    private void displayProducts() {
        while (true) {
            System.out.println("Product List:");
            for (Products product : productList) {
                System.out.println(product);
            }

            System.out.print("Enter product name to search or type 'back' to return: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("back")) {
                return; // Go back to the main menu
            }

            boolean found = false; // Flag to check if product is found
            for (Products product : productList) {
                if (product.getName().equalsIgnoreCase(input)) {
                    cart.add(product); // Add product to cart
                    System.out.println("Added to cart: " + product);
                    found = true; // Set flag to true if product is found
                    break; // Exit loop after adding the product
                }
            }

            if (!found) {
                System.out.println("Product not found. Please try again.");
            }
        }
    }

    // Method to display cart contents and handle checkout
    private void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        double total = 0;
        System.out.println("Your Cart:");
        for (Products product : cart) {
            System.out.println(product);
            total += product.getPrice();
        }
        System.out.printf("Total: %.2f\n", total);
        System.out.print("Would you like to checkout (yes/no)? ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("yes")) {
            checkout(total);
        }
    }

    // Method to handle the checkout process
    private void checkout(double total) {
        System.out.printf("Total amount due: $%.2f\n", total);
        System.out.print("Enter payment amount: ");
        double payment = scanner.nextDouble();
        if (payment >= total) {
            double change = payment - total;
            System.out.printf("Change given: $%.2f\n", change);
            System.out.println("Thank you for your purchase!");
            cart.clear(); // Clear the cart after checkout
        } else {
            System.out.println("Insufficient payment. Transaction canceled.");
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        StoreApp storeApp = new StoreApp();
        storeApp.displayMenu(); // Show the main menu
    }
}
