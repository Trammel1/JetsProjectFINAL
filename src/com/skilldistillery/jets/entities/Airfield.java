package com.skilldistillery.jets.entities;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Airfield {
	private List<AirVehicle> AVArr = new ArrayList<>();

	public Airfield() {
		super();
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[0].equals("Uav")) {
					AirVehicle uav = new Uav(temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]),
							Integer.parseInt(temp[4]));
					AVArr.add(uav);
				} else if (temp[0].equals("PassengerPlane")) {
					AirVehicle passplane = new PassengerPlane(temp[1], Integer.parseInt(temp[2]),
							Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
					AVArr.add(passplane);
				} else if (temp[0].equals("Jet")) {
					AirVehicle jet = new Jet(temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]),
							Integer.parseInt(temp[4]));
					AVArr.add(jet);
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public List<AirVehicle> getAVArr() {
		return AVArr;
	}

	public void setAVArr(List<AirVehicle> AVArr) {
		this.AVArr = AVArr;
	}

	public void addAirVehicle(AirVehicle fm) {
		AVArr.add(fm);
	}

	public void removeAirVehicle(int AirVehicle) {
		AVArr.remove(AirVehicle);
	}

	public void showAllAirVehicles() {

		for (int i = 0; i < AVArr.size(); i++) {
			System.out.println(AVArr.get(i));
			System.out.println();
		}
	}

	public void flyAllAirVehicles() {
		for (int i = 0; i < AVArr.size(); i++) {

			AVArr.get(i).fly();
			System.out.println();
		}
	}

	public void findFastestAirVehicle() {
		AirVehicle fastest = AVArr.get(0);
		for (int i = 0; i < AVArr.size(); i++) {
			if (AVArr.get(i).getSpeed() > fastest.getSpeed()) {
				fastest = AVArr.get(i);
			}
		}

		System.out.println("Fastest AirVehicle: ");
		System.out.println(fastest);
		System.out.println();

	}

	public void findLongestRangeAirvehicle() {

		AirVehicle longest = AVArr.get(0);
		for (int i = 0; i < AVArr.size(); i++) {
			if (AVArr.get(i).getRange() > longest.getRange()) {
				longest = AVArr.get(i);
			}
		}

		System.out.println("Longest Range Airvehicle: ");
		System.out.println(longest);
		System.out.println();

	}

	public void allUavsShoot() {
		for (int i = 0; i < AVArr.size(); i++) {
			if (AVArr.get(i) instanceof Uav) {

				Uav uav = (Uav) AVArr.get(i);
				uav.shootMissles();
				System.out.println();
			}
		}
	}

	public void boardAllPassengerPlanes() {
		for (int i = 0; i < AVArr.size(); i++) {
			if (AVArr.get(i) instanceof PassengerPlane) {

				PassengerPlane pp = (PassengerPlane) AVArr.get(i);
				pp.boardPassengers();
				System.out.println();
			}
		}
	}

	public void saveAirVehiclesToFile(String fileName) {

		if (fileName.equalsIgnoreCase("jets.txt")) {
			System.err.println(fileName + " already exists, nothing was saved. Try again..");
			return;
		}

		try (FileWriter fw = new FileWriter(fileName); PrintWriter pw = new PrintWriter(fw)) {
			for (AirVehicle fm : AVArr) {

				pw.println(fm.getClass().getSimpleName() + "," + fm.getModel() + "," + fm.getSpeed() + ","
						+ fm.getRange() + "," + fm.getPrice());
			}
			pw.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void allJetsDestroy() {
		for (int i = 0; i < AVArr.size(); i++) {
			if (AVArr.get(i) instanceof Jet) {

				Jet jet = (Jet) AVArr.get(i);
				jet.destroyEnemies();
				System.out.println();

			}

		}
	}
}
