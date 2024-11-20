package com.hlag.inventorymanagementsystem.repo;

import java.util.List;

import com.hlag.inventorymanagementsystem.entity.Product;

public interface InventoryRepo {

	void add(Product product);

	Product get(String productID);

	void update(String productID, Product updatedProduct);

	void delete(String productID);

	List<Product> getAllProducts();
}
