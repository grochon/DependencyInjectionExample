package com.rochon.car.supplier.parts.brakes;

import com.rochon.car.supplier.parts.tire.Tire;

public class Brake {

	private final Tire tire;
	private final double grip;
	
	private double padLife;

	public Brake(Tire tire, double grip, double padLife) {
		this.tire = tire;
		this.grip = grip;
		this.padLife = padLife;
	}
	
	public void brake(double pct) {
		double torque = grip * pct;
		padLife -= pct;
		if (padLife < 0.0) {
			System.out.println("KKKRRRRRRR!!!");
		} else if (padLife < 100.0) {
			System.out.println("squeak!");
		}
		tire.spin(-torque);
	}
	
}
