package com.rochon.car.manufacturer.tesla.modelS;

import com.rochon.car.manufacturer.tesla.common.ElectricDriveTrain;

public class AutoPilotModule {

	private ElectricDriveTrain driveTrain;
	
	public AutoPilotModule(ElectricDriveTrain driveTrain) {
		this.driveTrain = driveTrain;
	}
	
	public void enable() {
		System.out.println("Autopilot engaged!");
	}
	
	public void disable() {
		System.out.println("Autopilot disengaged.");
	}
	
}
