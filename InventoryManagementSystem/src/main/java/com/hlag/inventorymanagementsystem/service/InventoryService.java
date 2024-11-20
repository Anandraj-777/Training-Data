package com.hlag.inventorymanagementsystem.service;

import com.hlag.inventorymanagementsystem.entity.Product;

public interface InventoryService {

	void add(Product product);

	Product get(String productID);

	void update(String productID, Product updatedProduct);

	void delete(String productID);
}
