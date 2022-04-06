package com.skilldistillery.jets.entities;

public class Uav extends AirVehicle implements Shoot {

	public Uav(String model, int speed, int range, int price) {
		super(model, speed, range, price);
	}
		
	public void shootMissles() {
		int random = (int)(Math.random() * 100);
		System.out.println(random + " Target Destroyed!");
	}

	}
	

