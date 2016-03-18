package com.rochon.car.app.taxi;

import static com.rochon.car.manufacturer.ford.FordFactory.EngineOption.SIX_CYL;

import com.rochon.car.manufacturer.base.Car;
import com.rochon.car.manufacturer.ford.FordFactory;
import com.rochon.car.manufacturer.ford.fusion.FordFusionCar;

public class TaxiService {

	private final FordFactory ford;
	private final String carColor;
	
	public TaxiService(FordFactory ford, String carColor) {
		this.ford = ford;
		this.carColor = carColor;
	}
	
	public Car giveMeANewCar() {
		FordFusionCar car = ford.createFusion(carColor, SIX_CYL);
		addDecalsAndTaxiGear(car);
		return car;
	}

	private void addDecalsAndTaxiGear(FordFusionCar car) {
		// TODO Auto-generated method stub
	}
	
}
