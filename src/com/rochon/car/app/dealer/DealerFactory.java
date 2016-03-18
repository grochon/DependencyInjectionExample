package com.rochon.car.app.dealer;

import com.rochon.car.manufacturer.ford.FordFactoryImpl;
import com.rochon.car.manufacturer.tesla.TeslaFactoryImpl;

public class DealerFactory {

	public static Showroom createShowroom() {
		return new Showroom(new FordFactoryImpl(), new TeslaFactoryImpl());
	}
	
}
