package com.hlag.aircargosystem;

public class HeavyCargo extends Cargo {
	
	private boolean requiresSpecialEquipment;
	private double handlingFee;

	public HeavyCargo(String cargoId, String description, int weight, boolean requiresSpecialEquipment,double handlingFee) {
		super(cargoId, description, weight, requiresSpecialEquipment, handlingFee);
		this.requiresSpecialEquipment=requiresSpecialEquipment;
		this.handlingFee=handlingFee;
	}
	
	 public boolean isrequiresSpecialEquipment() {
		 return requiresSpecialEquipment;
	 }

	public double getHandlingFee() {
		return handlingFee;
	}

	public void setHandlingFee(double handlingFee) {
		this.handlingFee = handlingFee;
	}

	public void setRequiresSpecialEquipment(boolean requiresSpecialEquipment) {
		this.requiresSpecialEquipment = requiresSpecialEquipment;
	}

	 @Override
	 public void displayDetails() {
		 super.displayDetails();
		 System.out.println("Requires Special Equipment: " + requiresSpecialEquipment + ", Handling Fee: " + handlingFee);
	 }
}
