package com.pluralsight.store;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    // List to store items in the cart
    private List<Product> items;

    // Constructor
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // Method to add a product to the cart
    public void addProduct(Product product) {
        items.add(product);
    }

    // Method to remove a product from the cart
    public void removeProduct(Product product) {
        items.remove(product);
    }

    // Method to get all items in the cart
    public List<Product> getItems() {
        return new ArrayList<>(items);
    }

    // Method to calculate the total price of items in the cart
    public double getTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // Method to clear all items from the cart
    public void clear() {
        items.clear();
    }
}