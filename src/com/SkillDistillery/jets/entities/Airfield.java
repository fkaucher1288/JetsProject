package com.SkillDistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Airfield {

	private ArrayList<Jet> jets = new ArrayList<>();

	public ArrayList<Jet> getJets() {
		return jets;
	}

	public void setJets(ArrayList<Jet> jets) {
		this.jets = jets;
	}

	public void listOfJets(ArrayList<Jet> jetList) {

		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetFields = line.split(", ");
				if (jetFields[0].equals("HotAirBalloon")) {
					HotAirBalloon hap = new HotAirBalloon(jetFields[1], Double.parseDouble(jetFields[2]),
							Integer.parseInt(jetFields[3]), Long.parseLong(jetFields[4]));
					jets.add(hap);
				}
				if (jetFields[0].equals("FighterJet")) {
					FighterJet hap = new FighterJet(jetFields[1], Double.parseDouble(jetFields[2]),
							Integer.parseInt(jetFields[3]), Long.parseLong(jetFields[4]));
					jets.add(hap);
				}
				if (jetFields[0].equals("CargoPlane")) {
					CargoPlane hap = new CargoPlane(jetFields[1], Double.parseDouble(jetFields[2]),
							Integer.parseInt(jetFields[3]), Long.parseLong(jetFields[4]));
					jets.add(hap);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	public void buildJet(Scanner sc) {
		String type;
		String model;
		double speed;
		int range;
		long price;
		System.out.println("Please choose from the following types: Prop Plane, "
				+ "Cargo Plane, Hot Air Balloon, Fighter Jet, or Flying Saucer");
		type = sc.nextLine();
		System.out.println(type);
		System.out.println("Choose a model: ");
		model = sc.nextLine();
		System.out.println("Enter a speed: ");
		speed = sc.nextDouble();
		System.out.println("Enter a range: ");
		range = sc.nextInt();
		System.out.println("Enter a price: ");
		price = sc.nextLong();
		
		switch(type) {
		case "Prop Plane":
			jets.add(new PropPlane(model, speed, range, price));
			break;
		case "Cargo Plane":
			jets.add(new CargoPlane(model, speed, range, price));
			break;
		case "Hot Air Balloon":
			jets.add(new HotAirBalloon(model, speed, range, price));
			break;
		case "Fighter Jet":
			jets.add(new FighterJet(model, speed, range, price));
			break;
		case "Flying Saucer":
			jets.add(new FlyingSaucer(model, speed, range, price));
			break;
			default: System.out.println("Invalid option");
			break;
		}

	}
	
	public void removeJet(Scanner sc) {
		int type;
		System.out.println("Which plane would you like to remove?");
		type = sc.nextInt();
		jets.remove(type - 1);
		
		
	}

}
