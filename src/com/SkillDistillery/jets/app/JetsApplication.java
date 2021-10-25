package com.SkillDistillery.jets.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.SkillDistillery.jets.entities.Airfield;
import com.SkillDistillery.jets.entities.CargoCarrier;
import com.SkillDistillery.jets.entities.CombatReady;
import com.SkillDistillery.jets.entities.Jet;

public class JetsApplication {

	public static void main(String[] args) {
		boolean running = true;
		Airfield airfield = new Airfield();
		ArrayList<Jet> jets = airfield.getJets();
		airfield.listOfJets(jets);

		Scanner sc = new Scanner(System.in);
		while (running) {
			System.out.println("1. List fleet\n" + "2. Fly all jets\n" + "3. View fastest jet\n"
					+ "4. View jet with longest range\n" + "5. Load all Cargo Jets\n" + "6. Dogfight!\n"
					+ "7. Add a jet to Fleet\n" + "8. Remove a jet from Fleet\n" + "9. Quit");
			int userInput = sc.nextInt();
			sc.nextLine();
			switch (userInput) {
			case 1:
				for (Jet jet : airfield.getJets()) {
					System.out.println(jet);
				}
				break;
			case 2:
				for (Jet jet : airfield.getJets()) {
					jet.fly();
				}
				break;
			case 3:
				Jet fastestJet = null;
				for (Jet jet : airfield.getJets()) {
					if (fastestJet == null || jet.getSpeed() > fastestJet.getSpeed()) {
						fastestJet = jet;
					}

				}
				System.out.println(fastestJet);

			{

			}
				break;
			case 4:
				Jet longestRange = null;
				for (Jet jet : airfield.getJets()) {
					if (longestRange == null || jet.getRange() > longestRange.getRange()) {
						longestRange = jet;
					}

				}
				System.out.println(longestRange);
				break;
			case 5:
				for (Jet jet : airfield.getJets()) {
					if (jet instanceof CargoCarrier) {
						((CargoCarrier) jet).loadCargo();
					}

				}
				break;
			case 6:
				for (Jet jet : airfield.getJets()) {
					if (jet instanceof CombatReady) {
						((CombatReady) jet).Dogfight();
					}

				}
				break;
			case 7:
				airfield.buildJet(sc);

				break;
			case 8:
				airfield.removeJet(sc);
				break;
			case 9:
				running = false;
				System.out.println("Thank you for using JetApp! Goodbye.");
				break;
			}
		}

	}

}
