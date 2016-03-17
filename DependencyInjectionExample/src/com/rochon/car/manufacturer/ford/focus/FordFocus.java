package com.rochon.car.manufacturer.ford.focus;

import com.rochon.car.manufacturer.base.DriveTrain;
import com.rochon.car.manufacturer.base.RadioControls;
import com.rochon.car.manufacturer.base.SteeringWheelControls;
import com.rochon.car.supplier.parts.brakes.BrakingSystem;
import com.rochon.car.supplier.parts.door.PowerDoorLocks;
import com.rochon.car.supplier.parts.horn.Horn;
import com.rochon.car.supplier.parts.radio.Radio;

public class FordFocus implements FordFocusCar {

	private final PowerDoorLocks locks;
	private final Radio radio;
	private final Horn horn;
	private final DriveTrain driveTrain;
	private final BrakingSystem brakes;
	private final FordFocusBody body;
	
	
	public FordFocus(PowerDoorLocks locks, Radio radio, Horn horn,
			DriveTrain driveTrain, BrakingSystem brakes, FordFocusBody body) {
		this.locks = locks;
		this.radio = radio;
		this.horn = horn;
		this.driveTrain = driveTrain;
		this.brakes = brakes;
		this.body = body;
	}

	@Override
	public void lockDoors() {
		locks.lock();
	}

	@Override
	public void unlockDoors() {
		locks.unlock();
	}

	@Override
	public RadioControls radio() {
		return radioControls;
	}
	
	@Override
	public SteeringWheelControls steeringWheel() {
		return steeringWheel;
	}
	
	@Override
	public void accelerate(double pct) {
		driveTrain.accelerate(pct);
	}

	@Override
	public void brake(double pct) {
		brakes.brake(pct);
	}

	private final RadioControls radioControls = new RadioControls() {

		@Override
		public void on() {
			radio.on();
		}

		@Override
		public void off() {
			radio.off();
		}

		@Override
		public void volumeUp() {
			radio.volumeUp();
		}

		@Override
		public void volumeDown() {
			radio.volumeDown();
		}
		
	};
	
	private final SteeringWheelControls steeringWheel = new SteeringWheelControls() {
		
		@Override
		public void volumeUp() {
			radio.volumeUp();
		}
		
		@Override
		public void volumeDown() {
			radio.volumeDown();
		}
		
		@Override
		public void honk() {
			horn.honk();
		}
	};
	
}
