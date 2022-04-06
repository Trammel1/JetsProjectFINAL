package com.skilldistillery.jets.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.AirVehicle;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.PassengerPlane;
import com.skilldistillery.jets.entities.Uav;

public class JetsApplication {
	private Airfield airfield = new Airfield();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		JetsApplication ja = new JetsApplication();

		ja.launch();
		ja.sc.close();

	}

	private void launch() {
		boolean keepGoing = true;
		while (keepGoing) {
			int choice = 0;

			displayUserMenu();

			while (choice > 11 || choice < 1) {
				try {
					System.out.print("Enter 1-11: ");
					choice = sc.nextInt();

				} catch (InputMismatchException e) {
					System.err.println("Invalid input, enter 1-11.");
				}
				sc.nextLine();
			}

			switch (choice) {
			case 1:
				airfield.showAllAirVehicles();
				break;
			case 2:
				airfield.flyAllAirVehicles();
				break;
			case 3:
				airfield.findFastestAirVehicle();
				break;
			case 4:
				airfield.findLongestRangeAirvehicle();
				break;
			case 5:
				airfield.allUavsShoot();
				break;
			case 6:
				airfield.boardAllPassengerPlanes();
				break;
			case 7:
				airfield.allJetsDestroy();
				break;
			case 8:
				dislayAddAirVehicleMenu();
				break;
			case 9:
				displayRemoveMenu();
				break;
			case 10:
				System.out.print("\nPlease enter a file name to save AirVehicles: ");
				String file = sc.next();
				System.out.println();
				if (file.contains(".txt")) {
					System.err.println("Please only enter the file name.\n ");

					break;
				}
				file = file + ".txt";
				airfield.saveAirVehiclesToFile(file);
				break;
			case 11:
				if(	keepGoing = false) 
					System.exit(11);
				break;
				
			default:
				System.out.println("Something went wrong");
			}
		}

	}

	private void displayUserMenu() {
		System.out.println("Plese choose from the following: ");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all AirVehicle");
		System.out.println("3. View the fastest AirVehicle");
		System.out.println("4. View AirVehicle with Longest range");
		System.out.println("5. All Uav's Shoot");
		System.out.println("6. Board all passenger planes");
		System.out.println("7. All Jets Destroy");
		System.out.println("8. Add AirVehicle to fleet");
		System.out.println("9. Remove AirVehicle from fleet");
		System.out.println("10. Save AirVehicle to file");
		System.out.println("11. Quit");
	}

	private void dislayAddAirVehicleMenu() {

		int choice = 0;
		System.out.println();
		System.out.println("Select the type of AirVehicle you would like to add: ");
		System.out.println("1. UAV");
		System.out.println("2. Jet");
		System.out.println("3. Passenger Plane");
		System.out.println("4. Quit");

		while (choice < 1 || choice > 4) {
			System.out.println("Please enter 1-4");

			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid input, must enter number. No AirVehicle added ");

			}
			sc.nextLine();
		}

		if (choice == 4) {
			return;
		} else if (choice < 1 || choice > 4) {
			System.err.println("Invalid input, must enter 1-4. No AirVehicle added ");
			return;
		}

		System.out.print("Please enter model:  ");
		String model = sc.nextLine();

		int speed = 0;

		while (speed == 0) {
			try {
				System.out.print("Speed: ");
				speed = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Please enter a valid number. ");
			}
			sc.nextLine();
		}

		int range = 0;

		while (range == 0) {
			try {
				System.out.print("Range: ");
				range = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Plese enter a valid number. ");
			}
			sc.nextLine();
		}

		int price = 0;

		while (price == 0) {
			try {
				System.out.print("Price: ");
				price = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Plese enter a valid number. ");
			}
			sc.nextLine();
		}

		switch (choice) {
		case 1:
			AirVehicle uav = new Uav(model, speed, range, price);
			airfield.addAirVehicle(uav);
			break;
		case 2:
			AirVehicle jet = new Jet(model, speed, range, price);
			airfield.addAirVehicle(jet);
			break;
		case 3:
			AirVehicle pp = new PassengerPlane(model, speed, range, price);
			airfield.addAirVehicle(pp);
			break;

		default:
			System.out.println("ERROR");
		}

	}

	public void displayRemoveMenu() {

		System.out.println();
		System.out.println("Select the AirVehicle to remove ");
		System.out.println("Enter the model to remove:");
		System.out.println();
		airfield.showAllAirVehicles();
		System.out.println();
		System.out.println("Enter \"Quit\" to quit.");

		String choice = sc.nextLine();

		if (choice.equalsIgnoreCase("quit")) {
			return;
		}

		List<AirVehicle> AVArr = airfield.getAVArr();
		int arrSizeBeforeRemoval = AVArr.size();

		for (int i = 0; i < AVArr.size(); i++) {
			if (choice.equalsIgnoreCase(AVArr.get(i).getModel())) {
				System.out.println(AVArr.get(i).getModel() + " was removed");
				System.out.println();
				airfield.removeAirVehicle(i);
			}
		}

		if (arrSizeBeforeRemoval == AVArr.size()) {
			System.out.println("No AirVehicle was removed, error");
			System.out.println();
		}
	}

}
