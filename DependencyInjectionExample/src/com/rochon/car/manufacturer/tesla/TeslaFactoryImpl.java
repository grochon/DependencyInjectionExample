package com.rochon.car.manufacturer.tesla;

import java.util.HashSet;
import java.util.Set;

import com.rochon.car.manufacturer.tesla.common.ElectricDriveTrain;
import com.rochon.car.manufacturer.tesla.common.ElectricMotor;
import com.rochon.car.manufacturer.tesla.modelS.AutoPilotModule;
import com.rochon.car.manufacturer.tesla.modelS.TeslaModelS;
import com.rochon.car.manufacturer.tesla.modelS.TeslaModelSBody;
import com.rochon.car.manufacturer.tesla.modelS.TeslaModelSCar;
import com.rochon.car.supplier.parts.door.Door;
import com.rochon.car.supplier.parts.door.PowerDoorLocks;
import com.rochon.car.supplier.parts.horn.Horn;
import com.rochon.car.supplier.parts.radio.PremiumRadio;
import com.rochon.car.supplier.parts.tire.AllWeatherTire;

public class TeslaFactoryImpl implements TeslaFactory {

	public int hornVolume;
	public int radioMaxVolume = 5;
	public double motorPower = 3.5;
	public double motorBrakeFactor = 0.2;
	public double tirePressure = 35;
	public double windowSpeed = 3.0;
	
	@Override
	public TeslaModelSCar createModelS(String color) {
		Set<Door> doors = new HashSet<>(4);
		doors.add(new Door("front driver", color, windowSpeed));
		doors.add(new Door("front passenger", color, windowSpeed));
		doors.add(new Door("rear driver", color, windowSpeed));
		doors.add(new Door("rear passenger", color, windowSpeed));

		Set<ElectricMotor> motors = new HashSet<>();
		motors.add(new ElectricMotor(new AllWeatherTire(tirePressure), motorPower, motorBrakeFactor));
		motors.add(new ElectricMotor(new AllWeatherTire(tirePressure), motorPower, motorBrakeFactor));
		motors.add(new ElectricMotor(new AllWeatherTire(tirePressure), motorPower, motorBrakeFactor));
		motors.add(new ElectricMotor(new AllWeatherTire(tirePressure), motorPower, motorBrakeFactor));
		
		ElectricDriveTrain driveTrain = new ElectricDriveTrain(motors);
		
		return new TeslaModelS(
				new PowerDoorLocks(doors), 
				new PremiumRadio(radioMaxVolume), 
				new Horn(hornVolume), 
				driveTrain, 
				new TeslaModelSBody(color), 
				new AutoPilotModule(driveTrain));
	}
	
}
