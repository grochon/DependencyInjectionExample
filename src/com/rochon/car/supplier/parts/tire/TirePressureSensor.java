package com.rochon.car.supplier.parts.tire;

public class TirePressureSensor {

	private double calibration;
	
	private Tire tire;

	public TirePressureSensor(Tire tire, double calibration) {
		this.tire = tire;
		this.calibration = calibration;
	}
	
	public double check() {
		return tire.checkPressure() * calibration;
	}
	
}
