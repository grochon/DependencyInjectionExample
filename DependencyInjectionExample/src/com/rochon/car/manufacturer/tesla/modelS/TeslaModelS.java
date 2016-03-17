package com.rochon.car.manufacturer.tesla.modelS;

import com.rochon.car.manufacturer.base.RadioControls;
import com.rochon.car.manufacturer.base.SteeringWheelControls;
import com.rochon.car.manufacturer.tesla.common.ElectricDriveTrain;
import com.rochon.car.supplier.parts.brakes.BrakingSystem;
import com.rochon.car.supplier.parts.door.PowerDoorLocks;
import com.rochon.car.supplier.parts.horn.Horn;
import com.rochon.car.supplier.parts.radio.Radio;

public class TeslaModelS implements TeslaModelSCar {

	private final PowerDoorLocks locks;
	private final Radio radio;
	private final Horn horn;
	private final ElectricDriveTrain driveTrain;
	private final TeslaModelSBody body;
	private final AutoPilotModule autoPilot;

	public TeslaModelS(PowerDoorLocks locks, Radio radio, Horn horn,
			ElectricDriveTrain driveTrain, TeslaModelSBody body, AutoPilotModule autoPilot) {
		this.locks = locks;
		this.radio = radio;
		this.horn = horn;
		this.driveTrain = driveTrain;
		this.body = body;
		this.autoPilot = autoPilot;
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
	public void accelerate(double pct) {
		driveTrain.accelerate(pct);
	}

	@Override
	public void brake(double pct) {
		driveTrain.brake(pct);
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
	public void enableAutopilot() {
		autoPilot.enable();
	}

	@Override
	public void disableAutopilot() {
		autoPilot.disable();
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
