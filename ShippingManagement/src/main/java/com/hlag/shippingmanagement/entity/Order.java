package com.hlag.shippingmanagement.entity;

import java.time.LocalDate;

public class Order {

	    
	    private int id;
	    private String customer;
	    private String destination;
	    private double weight;
	    private String status;
	    private LocalDate orderDate;
	   
	    public Order(int id, String customer, String destination, double weight, String status) {
	        this.id = id;
	        this.customer = customer;
	        this.destination = destination;
	        this.weight = weight;
	        this.status = status;
	    }

	    
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    // Getter and Setter for customer
	    public String getCustomer() {
	        return customer;
	    }

	    public void setCustomer(String customer) {
	        this.customer = customer;
	    }

	    // Getter and Setter for destination
	    public String getDestination() {
	        return destination;
	    }

	    public void setDestination(String destination) {
	        this.destination = destination;
	    }

	    // Getter and Setter for weight
	    public double getWeight() {
	        return weight;
	    }

	    public void setWeight(double weight) {
	        this.weight = weight;
	    }

	    // Getter and Setter for status
	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
	    
	    public LocalDate getOrderDate() {
			return orderDate;
		}


		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}


		@Override
	    public String toString() {
	        return "Order ID: " + id + ", Customer: " + customer + ", Destination: " + destination
	                + ", Weight: " + weight + "kg, Status: " + status;
	    }
	}


