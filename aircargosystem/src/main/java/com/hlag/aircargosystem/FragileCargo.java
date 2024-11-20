package com.hlag.aircargosystem;

public class FragileCargo extends Cargo {
	
	 private String handlingInstructions;

	    public FragileCargo(String cargoId, String description, int weight, String instructions) {
	        super(cargoId, description, weight);
	        this.handlingInstructions = instructions;
	    }

	    public void displayHandlingInstructions() 
	    {
	        System.out.println("Handling Instructions: " + handlingInstructions);
	    }
	    
	    @Override
	    public void displayDetails() 
	    {
	    	super.displayDetails();
	    	System.out.println("this Cargo is fragile"+ handlingInstructions);
	    }
	    
	    public double caluculateShippingCost(double weight) 
	    {
	    	return weight * 2.8;
	    }
	    
	    public double calculateShippingCost(double weight, double distance)
	    {
	    	return weight * distance * 0.10;
	    }
	}

