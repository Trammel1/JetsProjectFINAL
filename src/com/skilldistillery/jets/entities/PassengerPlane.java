package com.skilldistillery.jets.entities;

public class PassengerPlane extends AirVehicle implements BoardPlane {

	public PassengerPlane(String model, int speed, int range, int price) {
		super(model, speed, range, price);

	}

	public void boardPassengers() {
		int passengers = (int) ((Math.random() * 100) + 42);
		int flightNumber = (int) ((Math.random() * 1000) + 42);
		System.out.println("BOARDING FLIGHT " + flightNumber);
		System.out.println("WELCOME TO FLIGHT 42 THERE ARE " + passengers + " PASSENGERS FLYING WITH US TODAY");
	}

}
