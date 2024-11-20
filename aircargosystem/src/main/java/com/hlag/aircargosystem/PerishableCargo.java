package com.hlag.aircargosystem;

public class PerishableCargo extends Cargo {

	 private int expirationDays;
	 private double temperatureRequirement;
	 
	public PerishableCargo(String cargoId, String description, int weight,int expirationDays,double temperatureRequirement) {
		super(cargoId, description, weight);
		this.expirationDays=expirationDays;
		this.temperatureRequirement=temperatureRequirement;
	}

	public int getExpirationDays() {
		return expirationDays;
	}

	public void setExpirationDays(int expirationDays) {
		this.expirationDays = expirationDays;
	}

	public double getTemperatureRequirement() {
		return temperatureRequirement;
	}

	public void setTemperatureRequirement(double temperatureRequirement) {
		this.temperatureRequirement = temperatureRequirement;
	}
	  
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Expiration Days:"+ expirationDays + ",Temperature Requirement:"+ temperatureRequirement+"°C");
	}
	
	public boolean isExpired() {
		return expirationDays <=0;
	}
	
	public void reduceExpirationDays(int days) {
		expirationDays -= days;
		if (expirationDays<0) expirationDays=0;
	}

}
