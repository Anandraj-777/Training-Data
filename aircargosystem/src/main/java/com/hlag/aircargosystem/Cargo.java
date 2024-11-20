package com.hlag.aircargosystem;

public class Cargo implements Trackable {

	    // Instance Variables
	    private String cargoId;
	    private String description;
	    private int weight;
	    private boolean requiresSpecialEquipment;
		private double handlingFee;

		
	    
	    public boolean isRequiresSpecialEquipment() {
			return requiresSpecialEquipment;
		}

		public void setRequiresSpecialEquipment(boolean requiresSpecialEquipment) {
			this.requiresSpecialEquipment = requiresSpecialEquipment;
		}

		public double getHandlingFee() {
			return handlingFee;
		}

		public void setHandlingFee(double handlingFee) {
			this.handlingFee = handlingFee;
		}

		public String getCargoId() {
			return cargoId;
		}

		public void setCargoId(String cargoId) {
			this.cargoId = cargoId;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getWeight(int weight) {
			return weight;
		}

		public void setWeight(int weight) {
			if (weight > 0) {
		        this.weight = weight;
		    } else {
		        System.out.println("Weight must be positive.");
		    }
		}

		// Constructor
	    public Cargo(String cargoId, String description, int weight,boolean requiresSpecialEquipment,double handlingFee) {
	        this.cargoId = cargoId;
	        this.description = description;
	        this.weight = weight;
	        this.requiresSpecialEquipment=requiresSpecialEquipment;
	        this.handlingFee=handlingFee;
	    }


		// Method to display cargo details
	    public void displayDetails() {
	        System.out.println("Cargo ID: " + cargoId + ", Description: " + description + ", Weight: " + weight);
	    }

	// Object Creation

	    public static void main(String[] args) {
	        Cargo cargo1 = new Cargo("C001", "Electronics", 100,false,100.0);
	        cargo1.displayDetails();
	        Cargo cargo2 = new FragileCargo("C002","Glassware", 30, "Handle with care.");
	        cargo2.displayDetails();
	    }

	@Override
	public void trackCargo() {
		System.out.println("Tracking cargo ID: " + cargoId);
    }

	}


