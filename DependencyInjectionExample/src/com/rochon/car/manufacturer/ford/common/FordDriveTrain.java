package com.rochon.car.manufacturer.ford.common;

import java.util.Set;

import com.rochon.car.manufacturer.base.DriveTrain;
import com.rochon.car.manufacturer.base.Engine;
import com.rochon.car.supplier.parts.tire.Tire;

public class FordDriveTrain implements DriveTrain {

	private static final double POWER_TO_TORQUE_FACTOR = 1.2;
	
	private final Engine engine;
	private final Set<Tire> tires;
	private final double efficiency;

	public FordDriveTrain(Engine engine, Set<Tire> tires, double efficiency) {
		this.engine = engine;
		this.tires = tires;
		this.efficiency = efficiency;
	}
	
	@Override
	public void accelerate(double pct) {
		double power = engine.accelerate(pct);
		double torque = powerToTorque(power);
		tires.forEach(t -> t.spin(torque));
	}
	
	private double powerToTorque(double power) {
		return power * efficiency * POWER_TO_TORQUE_FACTOR;
	}

}
