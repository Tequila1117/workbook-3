package com.pluralsight.store;

import java.util.List;
import java.util.Scanner;

public class StoreApp {
    // Static variables for store, cart, and scanner
    private static Store store;
    private static ShoppingCart cart;
    private static Scanner scanner;

    public static void main(String[] args) {
        // Initialize store, cart, and scanner
        store = new Store();
        cart = new ShoppingCart();
        scanner = new Scanner(System.in);

        // Main program loop
        while (true) {
            displayHomeScreen();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    displayCart();
                    break;
                case 3:
                    System.out.println("Thank you for shopping with us. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to display the home screen
    private static void displayHomeScreen() {
        System.out.println("\n===== Online Store Home =====");
        System.out.println("1. Display Products");
        System.out.println("2. Display Cart");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to handle product display and related actions
    private static void displayProducts() {
        while (true) {
            System.out.println("\n===== Products =====");
            System.out.println("1. View all products");
            System.out.println("2. Search products");
            System.out.println("3. Add product to cart");
            System.out.println("4. Go back to home");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayAllProducts();
                    break;
                case 2:
                    searchProducts();
                    break;
                case 3:
                    addProductToCart();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to display all products
    private static void displayAllProducts() {
        List<Product> products = store.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Method to search for products
    private static void searchProducts() {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();
        List<Product> results = store.searchProducts(query);
        if (results.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product product : results) {
                System.out.println(product);
            }
        }
    }

    // Method to add a product to the cart
    private static void addProductToCart() {
        System.out.print("Enter product SKU to add to cart: ");
        String sku = scanner.nextLine();
        Product product = store.getProductBySku(sku);
        if (product != null) {
            cart.addProduct(product);
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to display the cart and handle related actions
    private static void displayCart() {
        while (true) {
            System.out.println("\n=== Shopping Cart ===");
            List<Product> items = cart.getItems();
            if (items.isEmpty()) {
                System.out.println("Your cart is empty!");
            } else {
                for (Product item : items) {
                    System.out.println(item);
                }
                System.out.printf("Total: $%.2f%n", cart.getTotal());
            }

            System.out.println("\n1. Check out");
            System.out.println("2. Remove product from cart");
            System.out.println("3. Go back to home");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    checkOut();
                    return;
                case 2:
                    removeProductFromCart();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Sorry, that was an invalid choice. Please try again.");
            }
        }
    }

    // Method to handle the checkout process
    private static void checkOut() {
        System.out.println("Thank you for your purchase! Please visit us again!");
        System.out.printf("Total amount: $%.2f%n", cart.getTotal());
        cart.clear();
    }

    // Method to remove a product from the cart
    private static void removeProductFromCart() {
        System.out.print("Please enter product SKU to remove from cart: ");
        String sku = scanner.nextLine();
        List<Product> items = cart.getItems();
        for (Product item : items) {
            if (item.getSku().equals(sku)) {
                cart.removeProduct(item);
                System.out.println("Product is now removed from cart.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }
}
