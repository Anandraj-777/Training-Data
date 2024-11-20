package com.hlag.shippingmanagement.repository;

import java.util.List;

import com.hlag.shippingmanagement.entity.Shipment;

public interface ShipmentRepository {

	void add(Shipment shipment);

    Shipment get(int shipmentId);

    void update(int shipmentId, Shipment updatedShipment);

    void delete(int shipmentId);

    List<Shipment> getAllShipments();

    void updateStatus(int shipmentId, String status);
}
