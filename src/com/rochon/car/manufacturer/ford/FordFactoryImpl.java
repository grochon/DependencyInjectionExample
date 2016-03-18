package com.rochon.car.manufacturer.ford;

import static com.rochon.car.manufacturer.ford.FordFactory.EngineOption.FOUR_CYL;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

import com.rochon.car.manufacturer.base.Engine;
import com.rochon.car.manufacturer.base.SensitivityCurve;
import com.rochon.car.manufacturer.ford.common.FordDriveTrain;
import com.rochon.car.manufacturer.ford.common.FourCylinderEngine;
import com.rochon.car.manufacturer.ford.common.SixCylinderEngine;
import com.rochon.car.manufacturer.ford.focus.FordFocus;
import com.rochon.car.manufacturer.ford.focus.FordFocusBody;
import com.rochon.car.manufacturer.ford.focus.FordFocusCar;
import com.rochon.car.manufacturer.ford.fusion.FordFusion;
import com.rochon.car.manufacturer.ford.fusion.FordFusionBody;
import com.rochon.car.manufacturer.ford.fusion.FordFusionCar;
import com.rochon.car.supplier.parts.brakes.BaseBrakingSystem;
import com.rochon.car.supplier.parts.brakes.Brake;
import com.rochon.car.supplier.parts.door.Door;
import com.rochon.car.supplier.parts.door.PowerDoorLocks;
import com.rochon.car.supplier.parts.horn.Horn;
import com.rochon.car.supplier.parts.radio.BaseRadio;
import com.rochon.car.supplier.parts.radio.PremiumRadio;
import com.rochon.car.supplier.parts.tire.AllWeatherTire;
import com.rochon.car.supplier.parts.tire.StandardTire;
import com.rochon.car.supplier.parts.tire.Tire;

public class FordFactoryImpl implements FordFactory {

	private double fourCylinderPower = 4.0;
	private SensitivityCurve fourCylinderSensitivity;
	private double sixCylinderPower = 6.5;
	private SensitivityCurve sixCylinderSensitivity;

	public final FordFocusConfig focusConfig = new FordFocusConfig();
	public final FordFusionConfig fusionConfig = new FordFusionConfig();
	
	@Override
	public FordFocusCar createFocus(String color) {
		Set<Door> doors = new HashSet<>(4);
		doors.add(new Door("front driver", color, focusConfig.windowSpeed));
		doors.add(new Door("front passenger", color, focusConfig.windowSpeed));
		doors.add(new Door("rear driver", color, focusConfig.windowSpeed));
		doors.add(new Door("rear passenger", color, focusConfig.windowSpeed));
		
		Tire frontDriverTire, frontPassengerTire, rearDriverTire, rearPassengerTire;
		
		Set<Tire> tires = new HashSet<>(4);
		tires.add(frontDriverTire = new StandardTire(focusConfig.frontTirePressure));
		tires.add(frontPassengerTire = new StandardTire(focusConfig.frontTirePressure));
		tires.add(rearDriverTire = new StandardTire(focusConfig.rearTirePressure));
		tires.add(rearPassengerTire = new StandardTire(focusConfig.rearTirePressure));
		
		Set<Brake> brakes = new HashSet<>(4);
		brakes.add(new Brake(frontDriverTire, focusConfig.brakeGrip, focusConfig.brakePadLife));
		brakes.add(new Brake(frontPassengerTire, focusConfig.brakeGrip, focusConfig.brakePadLife));
		brakes.add(new Brake(rearDriverTire, focusConfig.brakeGrip, focusConfig.brakePadLife));
		brakes.add(new Brake(rearPassengerTire, focusConfig.brakeGrip, focusConfig.brakePadLife));
		
		return new FordFocus(
				new PowerDoorLocks(doors), 
				new BaseRadio(focusConfig.maxRadioVolume), 
				new Horn(focusConfig.hornVolume), 
				new FordDriveTrain(
						createEngine(FOUR_CYL), 
						tires, 
						focusConfig.driveTrainEfficiency), 
				new BaseBrakingSystem(brakes), 
				new FordFocusBody(color));
	}

	@Override
	public FordFusionCar createFusion(String color, EngineOption engineType) {
		Set<Door> doors = new HashSet<>(4);
		doors.add(new Door("front driver", color, fusionConfig.windowSpeed));
		doors.add(new Door("front passenger", color, fusionConfig.windowSpeed));
		doors.add(new Door("rear driver", color, fusionConfig.windowSpeed));
		doors.add(new Door("rear passenger", color, fusionConfig.windowSpeed));
		
		Tire frontDriverTire, frontPassengerTire, rearDriverTire, rearPassengerTire;
		
		Set<Tire> tires = new HashSet<>(4);
		tires.add(frontDriverTire = new AllWeatherTire(fusionConfig.frontTirePressure));
		tires.add(frontPassengerTire = new AllWeatherTire(fusionConfig.frontTirePressure));
		tires.add(rearDriverTire = new AllWeatherTire(fusionConfig.rearTirePressure));
		tires.add(rearPassengerTire = new AllWeatherTire(fusionConfig.rearTirePressure));
		
		Set<Brake> brakes = new HashSet<>(4);
		brakes.add(new Brake(frontDriverTire, fusionConfig.brakeGrip, fusionConfig.brakePadLife));
		brakes.add(new Brake(frontPassengerTire, fusionConfig.brakeGrip, fusionConfig.brakePadLife));
		brakes.add(new Brake(rearDriverTire, fusionConfig.brakeGrip, fusionConfig.brakePadLife));
		brakes.add(new Brake(rearPassengerTire, fusionConfig.brakeGrip, fusionConfig.brakePadLife));
		
		return new FordFusion(
				new PowerDoorLocks(doors), 
				new PremiumRadio(fusionConfig.maxRadioVolume), 
				new Horn(fusionConfig.hornVolume), 
				new FordDriveTrain(
						createEngine(engineType), 
						tires, 
						fusionConfig.driveTrainEfficiency), 
				new BaseBrakingSystem(brakes), 
				new FordFusionBody(color));
	}

	private Engine createEngine(EngineOption engineType) {
		switch (engineType) {
			case FOUR_CYL:
				return new FourCylinderEngine(fourCylinderPower, fourCylinderSensitivity);
			case SIX_CYL :
				return new SixCylinderEngine(sixCylinderPower, sixCylinderSensitivity);
			default :
				throw new RuntimeException("invalid engine type: " + engineType);
		}
	}

}
