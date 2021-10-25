package com.SkillDistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		
	}
	
	public void fly() {
		System.out.println("Model: " + getModel() + " Speed: " + getSpeed() + 
				" Range: " + getRange() + " Price: " + getPrice() + "Max Fly Time: "
				+ this.flyTime());
		
	}

	@Override
	public void Dogfight() {
		System.out.println("Scramble all fighters!!!");		
	}

}
