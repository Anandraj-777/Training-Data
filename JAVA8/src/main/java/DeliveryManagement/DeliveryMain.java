package DeliveryManagement;

import java.util.Arrays;
import java.util.List;

public class DeliveryMain {

	public static void main(String[] args) {

		List<Delivery> deliveries = Arrays.asList(new Delivery("D1", true, 1.5, 10.0, 50.0), // Completed
				new Delivery("D2", false, 2.0, 15.0, 70.0), // Pending
				new Delivery("D3", true, 1.0, 8.0, 40.0), // Completed
				new Delivery("D4", true, 3.0, 20.0, 90.0), // Completed
				new Delivery("D5", false, 0.5, 5.0, 20.0), // Pending
				new Delivery("D6", true, 2.0, 12.0, 80.0) // Completed
		);

		DeliveryRepositoryImpl deliveryRepo = new DeliveryRepositoryImpl();

		// Save initial deliveries to the repo
		deliveries.forEach(deliveryRepo::save);

		// Save new deliveries
		deliveryRepo.save(new Delivery("DEL001", false, 3.5, 10, 100)); // Not completed
		deliveryRepo.save(new Delivery("DEL002", false, 4.0, 5, 40)); // Not completed
		deliveryRepo.save(new Delivery("DEL003", true, 2.5, 8, 60)); // Completed

		// Mark delivery DEL002 as completed
		deliveryRepo.markDeliveryAsCompleted("DEL002");

		// Check if delivery DEL002 is marked as completed
		System.out.println("After marking DEL002 as completed:");
		deliveryRepo.findAll().forEach(
				delivery -> System.out.println(delivery.getDeliveryId() + " Completed: " + delivery.isCompleted()));

		// Mark delivery DEL001 as completed using filter/map
		deliveryRepo.markDeliveryAsCompletedUsingFilter("DEL001");

		// Check if delivery DEL001 is marked as completed
		System.out.println("\nAfter using filter/map:");
		deliveryRepo.findAll().forEach(
				delivery -> System.out.println(delivery.getDeliveryId() + " Completed: " + delivery.isCompleted()));

		// Mark delivery DEL002 as completed using map
		deliveryRepo.markDeliveryAsCompletedUsingMap("DEL002");

		// Check if delivery DEL002 is marked as completed
		System.out.println("\nAfter using map:");
		deliveryRepo.findAll().forEach(
				delivery -> System.out.println(delivery.getDeliveryId() + " Completed: " + delivery.isCompleted()));
		
      double totalRevenue = deliveryRepo.calculateTotalRevenue();
        
        System.out.println("Total Revenue: " + totalRevenue);
        
      double averageTime = deliveryRepo.avgDeliveryTime();
      
      System.out.println("Avg Delivery Time: " + averageTime);
      
      List<Delivery> topPerformingDeliveries = deliveryRepo.findTopKPerformingDeliveries(3);

      // Print the results
      System.out.println("Top 3 Performing Deliveries:");
      for (Delivery delivery : topPerformingDeliveries) {
          System.out.println("Delivery ID: " + delivery.getDeliveryId() +
                             ", Revenue: " + delivery.getRevenue() +
                             ", Delivery Time: " + delivery.getDeliveryTime() +
                             ", Completed: " + delivery.isCompleted());
      }

      // Optionally, calculate and display total revenue and average delivery time
      System.out.println("\nTotal Revenue: " + deliveryRepo.calculateTotalRevenue());
      System.out.println("Average Delivery Time: " + deliveryRepo.avgDeliveryTime());
      
      
  }
	
}
