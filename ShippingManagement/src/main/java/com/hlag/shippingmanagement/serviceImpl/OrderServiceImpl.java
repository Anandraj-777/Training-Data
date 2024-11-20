package com.hlag.shippingmanagement.serviceImpl;

import java.util.Comparator;
import java.util.List;

import com.hlag.shippingmanagement.entity.Order;
import com.hlag.shippingmanagement.repository.OrderRepository;
import com.hlag.shippingmanagement.repositoryImpl.OrderRepositoryImpl;
import com.hlag.shippingmanagement.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository = OrderRepositoryImpl.getInstance();
    private static OrderServiceImpl orderServiceImpl;

    public static OrderServiceImpl getInstance() {
        if (orderServiceImpl == null) {
            orderServiceImpl = new OrderServiceImpl();
        }
        return orderServiceImpl;
    }

    private OrderServiceImpl() {
    }

    @Override
    public void add(Order order) {
        if (order != null) {
        	orderRepository.add(order);
        }
    }

    @Override
    public Order get(int orderId) {
        return orderRepository.get(orderId);
    }

    @Override
    public void update(int orderId, Order updatedOrder) {
        Order existingOrder = get(orderId);
        if (existingOrder != null) {
        	orderRepository.update(orderId, updatedOrder);
        }
    }

    @Override
    public void delete(int orderId) {
        Order existingOrder = get(orderId);
        if (existingOrder != null) {
        	orderRepository.delete(orderId);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public List<Order> getAllOrdersSortedByDate() {
        List<Order> orders = orderRepository.getAllOrders();
        if (orders != null) {
            orders.sort(Comparator.comparing(Order::getOrderDate)); // This should work now
        }
        return orders;
    }

    public List<Order> getAllOrdersSortedByStatus() {
        List<Order> orders = orderRepository.getAllOrders();
        if (orders != null) {
            orders.sort(Comparator.comparing(Order::getStatus));
        }
        return orders;
    }
}