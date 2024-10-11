package com.pluralsight.store;

// Class that reps product/info in the store
public class Products {
    private String sku;
    private String name;
    private double price;
    private String department;




    // Constructor to initialize the Product
    public Products (String sku, String name, double price, String department) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }

    // Getter for the product name
    public String getName() {
        return name;
    }

   // Getter for product price
    public double getPrice() {
        return price;
    }

    // String format of products
    public String toString() {
        return String.format("SKU: %s | Name: %s | Price: %.2f | Department: %s", sku, name, price, department);
    }
}