package com.hlag.inventorymanagementsystem;

import java.util.List;
import java.util.Scanner;
import com.hlag.inventorymanagementsystem.entity.Product;
import com.hlag.inventorymanagementsystem.service.InventoryServiceImpl;

public class App {

    private static InventoryServiceImpl inventoryService = InventoryServiceImpl.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Products by Name");
            System.out.println("5. View Products by Price");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  
            switch (choice) {
                case 1:
                    app.addProduct();
                    break;
                case 2:
                    app.updateProduct();
                    break;
                case 3:
                    app.deleteProduct();
                    break;
                case 4:
                    app.viewProductsByName();
                    break;
                case 5:
                    app.viewProductsByPrice();
                    break;
                case 6:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product description: ");
        String description = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        
        String generatedProductID = "generatedID-" + System.currentTimeMillis(); 
        
        
        Product product = new Product(generatedProductID, name, description, price, quantity);
        inventoryService.add(product);
        System.out.println("Product added successfully.");
    }

    
    private void updateProduct() {
        System.out.print("Enter product ID to update: ");
        String productID = scanner.nextLine();
        Product existingProduct = inventoryService.get(productID);
        
        if (existingProduct != null) {
            System.out.println("Product found: " + existingProduct);
            System.out.println("1. Update Name");
            System.out.println("2. Update Price");
            System.out.println("3. Update Quantity");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter new product name: ");
                    String name = scanner.nextLine();
                    existingProduct.setName(name);
                    break;
                case 2:
                    System.out.print("Enter new product price: ");
                    double price = scanner.nextDouble();
                    existingProduct.setPrice(price);
                    break;
                case 3:
                    System.out.print("Enter new product quantity: ");
                    int quantity = scanner.nextInt();
                    existingProduct.setQuantity(quantity);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }
            inventoryService.update(productID, existingProduct);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    
    private void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        String productID = scanner.nextLine();
        Product existingProduct = inventoryService.get(productID);
        
        if (existingProduct != null) {
            inventoryService.delete(productID);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    
    private void viewProductsByName() {
        List<Product> products = inventoryService.getAllProductsSortedByName();
        displayProducts(products);
    }

    
    private void viewProductsByPrice() {
        List<Product> products = inventoryService.getAllProductsSortedByPrice();
        displayProducts(products);
    }

    
    private void displayProducts(List<Product> products) {
        System.out.println("\nProduct List:");
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
