package com.hlag.inventorymanagementsystem.entity;

public class Product {

    private String productID;
    private String name;
    private String description;
    private double price;
    private int quantity;

    
    public Product(String productID, String name, String description, double price, int quantity) {
        this.productID = productID; 
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    @Override
    public String toString() {
        return "ProductID: " + productID + ", Name: " + name + ", Description: " + description + ", Price: $" + price
                + ", Quantity: " + quantity;
    }
}
