package com.pluralsight.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Store {
    // List to store all products in the inventory
    private List<Product> inventory;

    // Constructor
    public Store() {
        this.inventory = new ArrayList<>();
        loadInventory();
    }

    // Method to load inventory from CSV file
    private void loadInventory() {
        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/DataFiles/products.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                inventory.add(new Product(
                        values[0], values[1], Double.parseDouble(values[2]), values[3]
                ));
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }

    // Method to get all products
    public List<Product> getAllProducts() {
        return new ArrayList<>(inventory);
    }

    // Method to search products based on a query
    public List<Product> searchProducts(String query) {
        List<Product> results = new ArrayList<>();
        for (Product p : inventory) {
            if (p.getName().toLowerCase().contains(query.toLowerCase()) ||
                    p.getDepartment().toLowerCase().contains(query.toLowerCase()) ||
                    String.valueOf(p.getPrice()).contains(query)) {
                results.add(p);
            }
        }
        return results;
    }

    // Method to get a product by its SKU
    public Product getProductBySku(String sku) {
        for (Product p : inventory) {
            if (p.getSku().equals(sku)) {
                return p;
            }
        }
        return null;
    }
}