package com.hlag.shippingmanagement.service;

import java.util.List;

import com.hlag.shippingmanagement.entity.Shipment;

public interface ShipmentService {
	
	void add(Shipment shipment);

    Shipment get(int shipmentId);

    void update(int shipmentId, Shipment updatedShipment);

    boolean delete(int shipmentId);

    List<Shipment> getAllShipments();

    void updateStatus(int shipmentId, String status);
}