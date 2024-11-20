package DeliveryManagement;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepository {

	 // Save a new delivery
    void save(Delivery delivery);

    // Find a delivery by its ID
    Optional<Delivery> findById(String deliveryId);

    // Get all deliveries
    List<Delivery> findAll();

    // Update an existing delivery
    void update(Delivery delivery);

    // Delete a delivery by its ID
    void deleteById(String deliveryId);

    // Get deliveries that are completed
    List<Delivery> findCompletedDeliveries();

	void markDeliveryAsCompletedUsingFilter(String deliveryId);

	void markDeliveryAsCompletedUsingMap(String deliveryId);

	void markDeliveryAsCompleted(String deliveryId);

	void removeCompletedDeliveries();
	
	double avgDeliveryTime();
}


