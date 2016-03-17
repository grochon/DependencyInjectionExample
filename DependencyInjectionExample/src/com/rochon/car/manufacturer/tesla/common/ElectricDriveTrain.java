package com.rochon.car.manufacturer.tesla.common;

import java.util.Set;

import com.rochon.car.manufacturer.base.DriveTrain;

public class ElectricDriveTrain implements DriveTrain {

	private final Set<ElectricMotor> motors;
	
	public ElectricDriveTrain(Set<ElectricMotor> motors) {
		this.motors = motors;
	}

	@Override
	public void accelerate(double pct) {
		motors.forEach(m -> m.accelerate(pct));
	}

	public void brake(double pct) {
		motors.forEach(m -> m.brake(pct));
	}
	
}
