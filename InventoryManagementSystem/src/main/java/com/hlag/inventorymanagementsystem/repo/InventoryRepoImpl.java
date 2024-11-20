package com.hlag.inventorymanagementsystem.repo;

import java.util.ArrayList;
import java.util.List;

import com.hlag.inventorymanagementsystem.entity.Product;

public class InventoryRepoImpl implements InventoryRepo {

	private static InventoryRepoImpl inventoryRepoImpl;

	private List<Product> productList = new ArrayList<>();

	private InventoryRepoImpl() {

	}

	public static InventoryRepoImpl getInstance() {
		if (inventoryRepoImpl == null) {
			inventoryRepoImpl = new InventoryRepoImpl();
		}
		return inventoryRepoImpl;
	}

	@Override
	public void add(Product product) {
	    if (product == null || product.getProductID() == null) {
	        throw new IllegalArgumentException("Product or Product ID cannot be null");
	    }
	    productList.add(product);
	    System.out.println("Product added successfully.");
	}

	@Override
	public Product get(String productID) {
	    if (productID == null) {
	        throw new IllegalArgumentException("Product ID cannot be null");
	    }
	    
	    return productList.stream()
	            .filter(product -> product.getProductID().equals(productID))
	            .findFirst()
	            .orElseThrow(() -> new IllegalArgumentException("Product not found"));
	}

	@Override
	public void update(String productID, Product updatedProduct) {
		Product existingProduct = get(productID);
		if (existingProduct != null) {
			int index = productList.indexOf(existingProduct);
			productList.set(index, updatedProduct);
			System.out.println("Product updated successfully.");
		} else {
			System.out.println("Product with ID " + productID + " not found.");
		}
	}

	@Override
	public void delete(String productID) {
		Product existingProduct = get(productID);
		if (existingProduct != null) {
			productList.remove(existingProduct);
			System.out.println("Product deleted successfully.");
		} else {
			System.out.println("Product with ID " + productID + " not found.");
		}
	}

	@Override
	public List<Product> getAllProducts() {
	    System.out.println("Getting all products");
	    return productList; 
	}
}