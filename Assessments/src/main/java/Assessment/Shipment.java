package Assessment;

class Shipment {

	private String destination;
	private String shipmentType;
	private String shippingDate;
	private String trackingNumber;
	private boolean insurance;
	private boolean giftWrap;

	@Override
	public String toString() {
		return "Shipment{" + "destination='" + destination + '\'' + ", shipmentType='" + shipmentType + '\''
				+ ", shippingDate='" + shippingDate + '\'' + ", trackingNumber='" + trackingNumber + '\''
				+ ", insurance=" + insurance + ", giftWrap=" + giftWrap + '}';
	}

	// private constructor accept the builder
	private Shipment(ShipmentBuilder builder) {
		this.destination = builder.destination;
		this.shipmentType = builder.shipmentType;
		this.shippingDate = builder.shippingDate;
		this.trackingNumber = builder.trackingNumber;
		this.insurance = builder.insurance;
	}

	static class ShipmentBuilder {
		private String destination;
		private String shipmentType;
		private String shippingDate;
		private String trackingNumber;
		private boolean insurance;
		private boolean giftWrap;

		// Mandatory fields via constructor
		public ShipmentBuilder(String destination, String shipmentType, String shippingDate) {
			this.destination = destination;
			this.shipmentType = shipmentType;
			this.shippingDate = shippingDate;
		}

		//Optional fields via setters
		public ShipmentBuilder setTrackingNumber(String trackingNumber) {
			this.trackingNumber = trackingNumber;
			return this;
		}

		public ShipmentBuilder setInsurance(boolean insurance) {
			this.insurance = insurance;
			return this;
		}

		public ShipmentBuilder setGiftWrap(boolean giftWrap) {
			this.giftWrap = giftWrap;
			return this;
		}
		
		// Build method to create the final Shipment object
        public Shipment build() {
            return new Shipment(this);
        }
	}
}
