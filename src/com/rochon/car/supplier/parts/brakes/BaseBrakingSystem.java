package com.rochon.car.supplier.parts.brakes;

import java.util.Set;

public class BaseBrakingSystem implements BrakingSystem {

	private final Set<Brake> brakes;
	
	public BaseBrakingSystem(Set<Brake> brakes) {
		this.brakes = brakes;
	}
	
	public void brake(double pct) {
		brakes.forEach(b -> b.brake(pct));
	}
	
}
