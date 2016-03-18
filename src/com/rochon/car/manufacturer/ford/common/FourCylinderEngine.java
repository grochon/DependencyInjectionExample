package com.rochon.car.manufacturer.ford.common;

import com.rochon.car.manufacturer.base.Engine;
import com.rochon.car.manufacturer.base.SensitivityCurve;

public class FourCylinderEngine implements Engine {
	
	private final double power;
	private final SensitivityCurve sensitivity;

	public FourCylinderEngine(double power, SensitivityCurve sensitivity) {
		this.power = power;
		this.sensitivity = sensitivity;
	}
	
	/** Returns the power output of the engine. */
	public double accelerate(double pct) {
		System.out.println("putt putt putt ...");
		return power * sensitivity.adjust(pct);
	}
	
}
