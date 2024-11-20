package com.hlag.shippingmanagement.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import com.hlag.shippingmanagement.entity.Order;
import com.hlag.shippingmanagement.repository.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository {

    private static OrderRepositoryImpl orderRepositoryImpl;

    private List<Order> orderList = new ArrayList<>();


    public static OrderRepositoryImpl getInstance() {
        if (orderRepositoryImpl == null) {
            orderRepositoryImpl = new OrderRepositoryImpl();
        }
        return orderRepositoryImpl;
    }

    @Override
    public void add(Order order) {
        if (order == null || order.getId() == 0) {
            throw new IllegalArgumentException("Order or Order ID cannot be null or zero");
        }
        orderList.add(order);
        System.out.println("Order added successfully.");
    }

    @Override
    public Order get(int orderId) {
        if (orderId == 0) {
            throw new IllegalArgumentException("Order ID cannot be zero");
        }
        
        return orderList.stream()
                .filter(order -> order.getId() == orderId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    @Override
    public void update(int orderId, Order updatedOrder) {
        Order existingOrder = get(orderId);
        if (existingOrder != null) {
            int index = orderList.indexOf(existingOrder);
            orderList.set(index, updatedOrder);
            System.out.println("Order updated successfully.");
        } else {
            System.out.println("Order with ID " + orderId + " not found.");
        }
    }

    @Override
    public void delete(int orderId) {
        Order existingOrder = get(orderId);
        if (existingOrder != null) {
            orderList.remove(existingOrder);
            System.out.println("Order deleted successfully.");
        } else {
            System.out.println("Order with ID " + orderId + " not found.");
        }
    }

    @Override
    public List<Order> getAllOrders() {
        System.out.println("Getting all orders");
        return orderList;
    }
}
