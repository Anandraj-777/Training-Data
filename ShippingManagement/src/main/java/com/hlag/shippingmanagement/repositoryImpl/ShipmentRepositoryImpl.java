package com.hlag.shippingmanagement.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import com.hlag.shippingmanagement.entity.Shipment;
import com.hlag.shippingmanagement.repository.ShipmentRepository;

public class ShipmentRepositoryImpl implements ShipmentRepository{

	private static ShipmentRepositoryImpl shipmentRepositoryImpl;

    private List<Shipment> shipmentList = new ArrayList<>();

    private ShipmentRepositoryImpl() {

    }

    public static ShipmentRepositoryImpl getInstance() {
        if (shipmentRepositoryImpl == null) {
            shipmentRepositoryImpl = new ShipmentRepositoryImpl();
        }
        return shipmentRepositoryImpl;
    }

    @Override
    public void add(Shipment shipment) {
        if (shipment == null || shipment.getId() == 0) {
            throw new IllegalArgumentException("Shipment or Shipment ID cannot be null or zero");
        }
        shipmentList.add(shipment);
        System.out.println("Shipment added successfully.");
    }

    @Override
    public Shipment get(int shipmentId) {
        if (shipmentId == 0) {
            throw new IllegalArgumentException("Shipment ID cannot be zero");
        }

        return shipmentList.stream()
                .filter(shipment -> shipment.getId() == shipmentId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Shipment not found"));
    }

    @Override
    public void update(int shipmentId, Shipment updatedShipment) {
        Shipment existingShipment = get(shipmentId);
        if (existingShipment != null) {
            int index = shipmentList.indexOf(existingShipment);
            shipmentList.set(index, updatedShipment);
            System.out.println("Shipment updated successfully.");
        } else {
            System.out.println("Shipment with ID " + shipmentId + " not found.");
        }
    }

    @Override
    public void delete(int shipmentId) {
        Shipment existingShipment = get(shipmentId);
        if (existingShipment != null) {
            shipmentList.remove(existingShipment);
            System.out.println("Shipment deleted successfully.");
        } else {
            System.out.println("Shipment with ID " + shipmentId + " not found.");
        }
    }

    @Override
    public List<Shipment> getAllShipments() {
        System.out.println("Getting all shipments");
        return shipmentList;
    }

    @Override
    public void updateStatus(int shipmentId, String status) {
        Shipment existingShipment = get(shipmentId);
        if (existingShipment != null) {
            existingShipment.setStatus(status);
            System.out.println("Shipment status updated to: " + status);
        } else {
            System.out.println("Shipment with ID " + shipmentId + " not found.");
        }
    }
}
