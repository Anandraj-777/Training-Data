package com.hlag.shippingmanagement.entity;

public class Shipment {
    // Attributes
    private int id;
    private String order;  // Assuming 'Order' is another class you have defined
    private String trackingNumber;
    private String assignedDriver;
	private String status;

    
    public Shipment(int id, String order, String trackingNumber, String assignedDriver, String status) {
	
		this.id = id;
		this.order = order;
		this.trackingNumber = trackingNumber;
		this.assignedDriver = assignedDriver;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getAssignedDriver() {
		return assignedDriver;
	}

	public void setAssignedDriver(String assignedDriver) {
		this.assignedDriver = assignedDriver;
	}

    @Override
    public String toString() {
        return "Shipment ID: " + id + ", Order: " + order + ", Tracking Number: " + trackingNumber
                + ", Assigned Driver: " + assignedDriver + ",ShipmentStatus:" + status;
    }


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status=status;
	}
}

