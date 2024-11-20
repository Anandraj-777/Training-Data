package com.hlag.shippingmanagement.service;

import java.util.List;

import com.hlag.shippingmanagement.entity.Order;

public interface OrderService {

	void add(Order order);

    Order get(int orderId);

    void update(int orderId, Order updatedOrder);

    void delete(int orderId);

    List<Order> getAllOrders();
}

