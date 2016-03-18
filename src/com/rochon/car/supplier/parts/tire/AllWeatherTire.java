package com.rochon.car.supplier.parts.tire;

public class AllWeatherTire implements Tire {

	private double pressure;
	
	public AllWeatherTire(double pressure) {
		this.pressure = pressure;
	}
	
	public double checkPressure() {
		return pressure;
	}
	
	public void spin(double torque) {
		if (torque < 0.5) {
			System.out.println("ooo");
		} else if (torque < 2.0) {
			System.out.println("oooooo");
		} else {
			System.out.println("oooooooooo");
		}
	}

}
