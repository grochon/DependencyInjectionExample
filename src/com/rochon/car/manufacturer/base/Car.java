package com.rochon.car.manufacturer.base;

public interface Car {

	void lockDoors();
	
	void unlockDoors();
	
	void accelerate(double pct);
	
	void brake(double pct);
	
	RadioControls radio();
	
	SteeringWheelControls steeringWheel();
	
}
