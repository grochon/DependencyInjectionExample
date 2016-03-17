package com.rochon.car.app.taxi;

import com.rochon.car.manufacturer.base.Car;

public class TaxiDriver {

	private final TaxiService service;
	private Car myCar;
	
	public TaxiDriver(TaxiService service) {
		this.service = service;
	}
	
	public void iNeedANewCar() {
		myCar = service.giveMeANewCar();
	}
	
}
