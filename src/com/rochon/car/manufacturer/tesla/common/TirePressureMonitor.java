package com.rochon.car.manufacturer.tesla.common;

import com.rochon.car.supplier.parts.tire.TirePressureSensor;

public class TirePressureMonitor {

	private double minPressure;
	private double maxPressure;
	private DriverNotifications notification;
	private TirePressureSensor[] sensors;

	public TirePressureMonitor(double minPressure, double maxPressure, DriverNotifications notification, TirePressureSensor...sensors) {
		this.minPressure = minPressure;
		this.maxPressure = maxPressure;
		this.notification = notification;
		this.sensors = sensors;
	}
	
	public void monitor() {
		for (TirePressureSensor sensor : sensors) {
			double pressure = sensor.check();
			if (pressure < minPressure || pressure > maxPressure) {
				notification.setTirePressureWarning(true);
				return;
			}
		}
		notification.setTirePressureWarning(false);
	}
	
}
