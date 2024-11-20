package Assessment;

public interface Shipments {

	 void deliver() ;
		
}

class Airshipment implements Shipments {

	@Override
	public void deliver() {
		System.out.println("Delivering by air.");	
	}	
}
class SeaShipment implements Shipments {
	 @Override
	 public void deliver() {
	     System.out.println("Delivering by sea.");
	 }
	}

	class LandShipment implements Shipments {
	 @Override
	 public void deliver() {
	     System.out.println("Delivering by land.");
	 }
	}
	
	class ShipmentFactory {
		 // Factory method to create Shipment objects
		 public static Shipments createShipment(String shipmentType) {
		     switch (shipmentType.toLowerCase()) {
		         case "air":
		             return new Airshipment();
		         case "sea":
		             return new SeaShipment();
		         case "land":
		             return new LandShipment();
		         default:
		             throw new IllegalArgumentException("Invalid shipment type: " + shipmentType);
		     }
		 }
		}

	
