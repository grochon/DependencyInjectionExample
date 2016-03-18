package com.rochon.car.manufacturer.tesla.common;

import com.rochon.car.supplier.parts.tire.Tire;

public class ElectricMotor {

	private Tire tire;
	private double power;
	private double brakeFactor;
	
	public ElectricMotor(Tire tire, double power, double brakeFactor) {
		this.tire = tire;
		this.power = power;
		this.brakeFactor = brakeFactor;
	}

	public void accelerate(double pct) {
		tire.spin(power * pct);
	}
	
	public void brake(double pct) {
		tire.spin(-(power * brakeFactor * pct));
	}
	
}
