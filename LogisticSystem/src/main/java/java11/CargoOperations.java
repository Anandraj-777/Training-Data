package java11;

public class CargoOperations {

	 private int cargoWeight1 = 500; 
	    private int cargoWeight2 = 600; 
	    private String flightNumber = "AI202"; 
	    private boolean isFragile = true; 
	    private int maxStandardWeight = 1000; 

	 
	    public CargoOperations() {}

	 
	    public CargoOperations(int cargoWeight1, int cargoWeight2, String flightNumber, boolean isFragile, int maxStandardWeight) {
	        this.cargoWeight1 = cargoWeight1;
	        this.cargoWeight2 = cargoWeight2;
	        this.flightNumber = flightNumber;
	        this.isFragile = isFragile;
	        this.maxStandardWeight = maxStandardWeight;
	    }

	    //Using Arithmetic Operators
	    public int calculateTotalWeight() {
	        int totalWeight = cargoWeight1 + cargoWeight2;
	        System.out.println("Total weight of cargo: " + totalWeight + " kg");
	        return totalWeight;
	    }

	    //Using Relational Operators
	    public void checkWeightLimit(int totalWeight) {
	        if (totalWeight > maxStandardWeight) {
	            System.out.println("Total weight exceeds the maximum standard limit.");
	        } else {
	            System.out.println("Total weight is within the standard limit.");
	        }
	    }

	    //Using Logical Operators
	    public void checkHandlingRequirements(int totalWeight) {
	        boolean isOverSized = totalWeight > 1300;

	        if (isFragile && isOverSized) {
	            System.out.println("Handle with care: Cargo is fragile and oversized.");
	        } else if (isFragile || totalWeight > maxStandardWeight) {
	            System.out.println("Special handling required for either fragile or heavy cargo.");
	        } else {
	            System.out.println("Standard handling is sufficient.");
	        }
	    }
	}
