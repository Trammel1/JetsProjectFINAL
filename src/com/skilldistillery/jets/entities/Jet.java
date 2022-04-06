package com.skilldistillery.jets.entities;

public class Jet extends AirVehicle implements Destroy{

	
	

	public Jet(String model, int speed, int range, int price) {
		super(model, speed, range, price);
		
	}
	public void destroyEnemies() {
		int rounds = (int)((Math.random() * 100) + 34);
		
		System.out.println(rounds + " Rounds Fired! brrrttttt...");
	}
}
