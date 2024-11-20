package com.hlag.shippingmanagement.serviceImpl;

import java.util.List;

import com.hlag.shippingmanagement.entity.Shipment;
import com.hlag.shippingmanagement.repository.ShipmentRepository;
import com.hlag.shippingmanagement.repositoryImpl.ShipmentRepositoryImpl;
import com.hlag.shippingmanagement.service.ShipmentService;

public class ShipmentServiceImpl implements ShipmentService{

	private ShipmentRepository shipmentRepository = ShipmentRepositoryImpl.getInstance();
    private static ShipmentServiceImpl shipmentServiceImpl;

    public static ShipmentServiceImpl getInstance() {
        if (shipmentServiceImpl == null) {
            shipmentServiceImpl = new ShipmentServiceImpl();
        }
        return shipmentServiceImpl;
    }

    private ShipmentServiceImpl() {
    }

    @Override
    public void add(Shipment shipment) {
        if (shipment != null) {
            shipmentRepository.add(shipment);
        }
    }

    @Override
    public Shipment get(int shipmentId) {
        return shipmentRepository.get(shipmentId);
    }

    @Override
    public void update(int shipmentId, Shipment updatedShipment) {
        Shipment existingShipment = get(shipmentId);
        if (existingShipment != null) {
            shipmentRepository.update(shipmentId, updatedShipment);
        }
    }

    @Override
    public boolean delete(int shipmentId) {
        Shipment existingShipment = get(shipmentId);
        if (existingShipment != null) {
            shipmentRepository.delete(shipmentId);
        }
		return false;
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.getAllShipments();
    }

    @Override
    public void updateStatus(int shipmentId, String status) {
        Shipment shipment = get(shipmentId);
        if (shipment != null) {
            shipment.setStatus(status); // Assuming `setStatus` is a method in the `Shipment` entity
            shipmentRepository.update(shipmentId, shipment); // Update the shipment status in the repository
        }
    }

	public List<Shipment> getShipmentsByAssignedDriver(String assignedDriver) {
		// TODO Auto-generated method stub
		return null;
	}

}