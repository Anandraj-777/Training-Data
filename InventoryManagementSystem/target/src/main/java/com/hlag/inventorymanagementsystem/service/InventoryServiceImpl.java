package com.hlag.inventorymanagementsystem.service;

import java.util.Comparator;
import java.util.List;

import com.hlag.inventorymanagementsystem.entity.Product;
import com.hlag.inventorymanagementsystem.repo.InventoryRepo;
import com.hlag.inventorymanagementsystem.repo.InventoryRepoImpl;

public class InventoryServiceImpl implements InventoryService {

	private InventoryRepo inventoryRepo = InventoryRepoImpl.getInstance();
	private static InventoryServiceImpl inventoryServiceImpl;

	public static InventoryServiceImpl getInstance() {
		if (inventoryServiceImpl == null) {
			inventoryServiceImpl = new InventoryServiceImpl();
		}
		return inventoryServiceImpl;
	}

	private InventoryServiceImpl() {

	}

	@Override
    public void add(Product product) {
        if (product != null) {
            inventoryRepo.add(product);
        } else {
            System.out.println("Cannot add null product.");
        }
    }

	@Override
    public Product get(String productID) {
        Product product = inventoryRepo.get(productID);
        if (product == null) {
            System.out.println("Product with ID " + productID + " not found.");
        }
        return product;
    }


    @Override
    public void update(String productID, Product updatedProduct) {
        Product existingProduct = get(productID);
        if (existingProduct != null) {
            inventoryRepo.update(productID, updatedProduct);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product with ID " + productID + " not found, cannot update.");
        }
    }

    @Override
    public void delete(String productID) {
        Product existingProduct = get(productID);
        if (existingProduct != null) {
            inventoryRepo.delete(productID);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product with ID " + productID + " not found, cannot delete.");
        }
    }

	public List<Product> getAllProductsSortedByName() {
		List<Product> products = inventoryRepo.getAllProducts();
		products.sort(Comparator.comparing(Product::getName));
		return products;
	}

	public List<Product> getAllProductsSortedByPrice() {
		List<Product> products = inventoryRepo.getAllProducts();
		products.sort(Comparator.comparingDouble(Product::getPrice));
		return products;
	}

}