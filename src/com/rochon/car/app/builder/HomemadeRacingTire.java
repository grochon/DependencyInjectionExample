package com.rochon.car.app.builder;

import java.util.Random;

import com.rochon.car.supplier.parts.tire.Tire;

public class HomemadeRacingTire implements Tire {
	
	private final Random rand;
	private final double blowoutPct;
	
	private double pressure;

	public HomemadeRacingTire(Random random, double blowoutPct, double pressure) {
		this.rand = random;
		this.blowoutPct = blowoutPct;
		this.pressure = pressure;
	}
	
	@Override
	public double checkPressure() {
		return pressure;
	}

	@Override
	public void spin(double torque) {
		if (rand.nextDouble() < blowoutPct) {
			pressure = 0;
			throw new RuntimeException("BLOWOUT!!!");
		}
		System.out.println("ooo");
	}

}
