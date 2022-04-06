package com.skilldistillery.jets.entities;

public class AirVehicle {
	private String model;
	private int speed;
	private int range;
	private long price;
	
	public AirVehicle(String model, int speed, int range, int price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	// Getters and Setters

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	// End of Getters and Setters
	
	public void fly() {
		System.out.println(this.toString());
		System.out.println(this.getModel() + " can fly for " + this.flightTime());
	} 
	
	public String flightTime() {
		int time = (this.range / this.speed) * 60;
		int hours = (int) (time / 60);
		int minutes = (int)(time % 60);
		
		if (hours == 0) {
			return minutes + " minutes";
		} else if (minutes == 0) {
			return hours + "hours";
		} else {
			return hours + " hours and " + minutes + " minutes";
			
		}
	}
	
	public String toString() {
		return "Type: " + this.getClass().getSimpleName() + " | Model: " + this.model + " | Speed: " + this.speed + " | Range: " + this.range + " | Price: " + this.price;
	}
	
}
