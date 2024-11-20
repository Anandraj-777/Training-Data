package Assessment;

public class Main {

	public static void main(String[] args) {
//        // Building a shipment with all attributes
//        Shipment shipment = new Shipment.ShipmentBuilder("New York", "Overnight", "2024-11-25")
//                .setTrackingNumber("TRACK123456789")
//                .setInsurance(true)
//                .setGiftWrap(true)
//                .build();
//
//        System.out.println(shipment);
//
//        // Building another shipment with a different configuration (no insurance and gift wrap)
//        Shipment shipment2 = new Shipment.ShipmentBuilder("Los Angeles", "Standard", "2024-11-28")
//                .setTrackingNumber("TRACK987654321")
//                .build();
//
//        System.out.println(shipment2);

		     // Create different shipments using the factory
		     Shipments airShipment = ShipmentFactory.createShipment("air");
		     Shipments seaShipment = ShipmentFactory.createShipment("sea");
		     Shipments landShipment = ShipmentFactory.createShipment("land");

		     // Deliver the shipments
		     airShipment.deliver();
		     seaShipment.deliver();
		     landShipment.deliver();
		 }
		
    }
