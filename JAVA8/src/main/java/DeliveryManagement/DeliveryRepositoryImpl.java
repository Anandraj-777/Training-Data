package DeliveryManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeliveryRepositoryImpl implements DeliveryRepository {

	private List<Delivery> deliveries = new ArrayList<>();

	// Save a new delivery
	@Override
	public void save(Delivery delivery) {
		deliveries.add(delivery);
	}

	// Find a delivery by its ID
	@Override
	public Optional<Delivery> findById(String deliveryId) {
		return deliveries.stream().filter(delivery -> delivery.getDeliveryId().equals(deliveryId)).findFirst();
	}

	// Get all deliveries
	@Override
	public List<Delivery> findAll() {
		return new ArrayList<>(deliveries);
	}

	// Update an existing delivery
	@Override
	public void update(Delivery delivery) {
		Optional<Delivery> existingDelivery = findById(delivery.getDeliveryId());
		if (existingDelivery.isPresent()) {
			deliveries.remove(existingDelivery.get());
			deliveries.add(delivery);
		}
	}

	// Delete a delivery by its ID
	@Override
	public void deleteById(String deliveryId) {
		deliveries.removeIf(delivery -> delivery.getDeliveryId().equals(deliveryId));
	}

	@Override
	public void removeCompletedDeliveries() {
		deliveries.removeIf(Delivery::isCompleted); // Remove deliveries with completed status as true
	}

	// Get deliveries that are completed
	@Override
	public List<Delivery> findCompletedDeliveries() {
		List<Delivery> completedDeliveries = new ArrayList<>();
		for (Delivery delivery : deliveries) {
			if (delivery.isCompleted()) {
				completedDeliveries.add(delivery);
			}
		}
		return completedDeliveries;
	}

	@Override
	public void markDeliveryAsCompleted(String deliveryId) {
		deliveries = deliveries.stream().map(delivery -> {
			if (delivery.getDeliveryId().equals(deliveryId)) {
				delivery.setCompleted(true);
			}
			return delivery;
		}).collect(Collectors.toList());
	}

	@Override
	public void markDeliveryAsCompletedUsingFilter(String deliveryId) {
		deliveries = deliveries.stream().filter(delivery -> delivery.getDeliveryId().equals(deliveryId))
				.map(delivery -> {
					delivery.setCompleted(true);
					return delivery;
				}).collect(Collectors.toList());
	}

	@Override
	public void markDeliveryAsCompletedUsingMap(String deliveryId) {
		deliveries = deliveries.stream().map(delivery -> {
			if (delivery.getDeliveryId().equals(deliveryId)) {
				delivery.setCompleted(true);
			}
			return delivery;
		}).collect(Collectors.toList());
	}

	public double calculateTotalRevenue() {
		return deliveries.stream().mapToDouble(e -> e.getRevenue()).sum();

	}

	@Override
	public double avgDeliveryTime() {
		return deliveries.stream().mapToDouble(e -> e.getDeliveryTime()).average().orElse(0);

	}

	public List<Delivery> findTopKPerformingDeliveries(int k) {
		return deliveries.stream().filter(e -> e.isCompleted())
				.sorted((a, b) -> Double.compare(a.getDeliveryTimeInHours(), b.getDeliveryTimeInHours())).limit(k)
				.toList();

	}
      public double calculateTotalRevenue1() throws IllegalAccessException {
    	  return deliveries.stream().mapToDouble(e->e.getDeliveryTimeInHours()).average().orElseThrow(()->new IllegalAccessException("data is not provide"));
      }
}