package com.rochon.car.app.builder;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.rochon.car.app.common.AppConfig;
import com.rochon.car.app.common.NullAppConfig;
import com.rochon.car.manufacturer.base.Car;
import com.rochon.car.manufacturer.base.RadioControls;
import com.rochon.car.manufacturer.base.SteeringWheelControls;
import com.rochon.car.manufacturer.tesla.common.ElectricDriveTrain;
import com.rochon.car.manufacturer.tesla.common.ElectricMotor;
import com.rochon.car.supplier.parts.door.Door;
import com.rochon.car.supplier.parts.door.PowerDoorLocks;
import com.rochon.car.supplier.parts.horn.Horn;

public class CarBuilder {

	private final Random random;
	private final AppConfig config;
	
	private Car myCar;
	
	public static void main(String[] args) {
		CarBuilder carGuy = new CarBuilder(new NullAppConfig(), new Random());
		carGuy.buildMyDreamCar();
		carGuy.takeATestDrive();
	}
	
	public CarBuilder(AppConfig config, Random random) {
		this.config = config;
		this.random = random;
	}
	
	public void buildMyDreamCar() {
		double goFastFactor = config.doubleValue("goFastFactor", 1.0);
		
		Set<Door> doors = new HashSet<>(2);
		doors.add(new Door("driver side", config.stringValue("carColor", "racing blue"), 0.0));
		doors.add(new Door("passenger side", config.stringValue("carColor", "racing blue"), 0.0));
		
		Set<ElectricMotor> motors = new HashSet<>(4);
		motors.add(assembleMotor());
		motors.add(assembleMotor());
		motors.add(assembleMotor());
		motors.add(assembleMotor());
		
		myCar = new Car() {

			private PowerDoorLocks locks = new PowerDoorLocks(doors);
			private ElectricDriveTrain driveTrain = new ElectricDriveTrain(motors);
			private Horn horn = new Horn(config.intValue("honkVolume", 105));
			
			@Override
			public void lockDoors() {
				locks.lock();
			}

			@Override
			public void unlockDoors() {
				locks.unlock();
			}

			@Override
			public void accelerate(double pct) {
				driveTrain.accelerate(pct * goFastFactor);
			}

			@Override
			public void brake(double pct) {
				driveTrain.brake(pct);
			}

			@Override
			public RadioControls radio() {
				throw new UnsupportedOperationException("no radio");
			}

			@Override
			public SteeringWheelControls steeringWheel() {
				return steeringWheel;
			}
			
			private final SteeringWheelControls steeringWheel = new SteeringWheelControls() {
				
				@Override
				public void volumeUp() {
					throw new UnsupportedOperationException("no radio");
				}
				
				@Override
				public void volumeDown() {
					throw new UnsupportedOperationException("no radio");
				}
				
				@Override
				public void honk() {
					horn.honk();
				}
			};
		};
	}
	
	public void takeATestDrive() {
		myCar.unlockDoors();
		myCar.accelerate(100.0);
		myCar.accelerate(100.0);
		myCar.accelerate(100.0);
		myCar.accelerate(100.0);
		myCar.accelerate(100.0);
		myCar.brake(100.0);
		myCar.lockDoors();
	}

	private ElectricMotor assembleMotor() {
		HomemadeRacingTire tire = new HomemadeRacingTire(random, 
				config.doubleValue("tireBlowoutChance", 0.10), 
				config.doubleValue("tirePressure", 35));
		
		return new ElectricMotor(tire, 
				config.doubleValue("motorPower", 12.0), 
				config.doubleValue("motorBrakingFactor", 0.2));
	}
	
}
