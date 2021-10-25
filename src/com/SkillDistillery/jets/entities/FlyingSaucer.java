package com.SkillDistillery.jets.entities;

public class FlyingSaucer extends Jet {

	public FlyingSaucer(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		
	}
	
	public void fly() {
		System.out.println("Model: " + getModel() + " Speed: " + getSpeed() + 
				" Range: " + getRange() + " Price: " + getPrice() + "Max Fly Time: "
				+ this.flyTime());
		
	}

}
