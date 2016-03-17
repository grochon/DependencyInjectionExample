package com.rochon.car.supplier.parts.brakes;

import java.util.Set;

public class AntiLockBrakingSystem implements BrakingSystem {

	private final Set<Brake> brakes;
	private final int pumps;
	private final double pumpPressure;
	
	public AntiLockBrakingSystem(Set<Brake> brakes, int pumps, double pumpPressure) {
		this.brakes = brakes;
		this.pumps = pumps;
		this.pumpPressure = pumpPressure;
	}
	
	@Override
	public void brake(double pct) {
		for (int i = 0; i < pumps; i++) {
			brakes.forEach(b -> b.brake(pct * pumpPressure));
		}
	}

}
