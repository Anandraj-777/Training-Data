package DeliveryManagement;

public class Delivery {

	private String deliveryId;
	private boolean completed;
	private double deliveryTimeInHours;
	private double parcelWeight;
	private double revenue;
	private double deliveryTime;

	public Delivery() {

	}

	public Delivery(String deliveryId, boolean completed, double deliveryTimeInHours, double parcelWeight,
			double revenue) {

		this.deliveryId = deliveryId;
		this.completed = completed;
		this.deliveryTimeInHours = deliveryTimeInHours;
		this.parcelWeight = parcelWeight;
		this.revenue = revenue;
	}

	public String getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public double getDeliveryTimeInHours() {
		return deliveryTimeInHours;
	}

	public void setDeliveryTimeInHours(double deliveryTimeInHours) {
		this.deliveryTimeInHours = deliveryTimeInHours;
	}

	public double getParcelWeight() {
		return parcelWeight;
	}

	public void setParcelWeight(double parcelWeight) {
		this.parcelWeight = parcelWeight;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public double getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(double deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	public double getRevenueToTimeRatio() {
        if (deliveryTime == 0) {  // Avoid division by zero
            return 0.0;
        }
        return revenue / deliveryTime;
    }
}
