package com.hlag.logisticsystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pacakge {
	
	 
		private String trackingId="";
		private double weight;
		private String destination;
		private String status;
		private List<String> milestones;
	 
		public String getTrackingId() {
			return trackingId;
		}
	 
		public double getWeight() {
			return weight;
		}
	 
		public void setWeight(double weight) {
			this.weight = weight;
		}
	 
		public String getDestination() {
			return destination;
		}
	 
		public void setDestination(String destination) {
			this.destination = destination;
		}
	 
		public String getStatus() {
			return status;
		}
	 
		public void setStatus(String status) {
			this.status = status;
		}
	 
		public List<String> getMilestones() {
			return Collections.unmodifiableList(milestones);
		}
		
	 public void markAsDelivered(String status) {
			 
			 if(this.status.equals(status)) {
				 throw new IllegalArgumentException("pacakge is in transist");
			 }
			   this.status="deliverd";
			   this.milestones.add("deliverd on" +LocalDate.now());
			   
		 }
	 
//		public void Package(String trackingId, String destination, double weight) {
//			
//			this.trackingId = trackingId;
//			this.destination = destination;
//			this.status = "In Transit"; // Initial status
//			this.milestones = new ArrayList<>();
//			setWeight(weight);
//		}
	 
	     private static Package pack;
	     private static Package getInstance() {
	    	 
	    	 if(pack==null) {
	    		 pack=new Package();
	    	 }
			return pack;
	    	 
	     }
	
	}
	 
