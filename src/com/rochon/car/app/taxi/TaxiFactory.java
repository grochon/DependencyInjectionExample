package com.rochon.car.app.taxi;

import com.rochon.car.app.common.AppConfig;
import com.rochon.car.manufacturer.ford.FordFactoryImpl;

public class TaxiFactory {

	private final AppConfig config;
	
	private TaxiService taxiService;
	
	public TaxiFactory(AppConfig config) {
		this.config = config;
	}
	
	public TaxiService createTaxiService() {
		FordFactoryImpl ford = new FordFactoryImpl();
		ford.fusionConfig.hornVolume = config.intValue("hornVolume", 20);
		ford.fusionConfig.brakePadLife = config.doubleValue("brakePadLife", 5000);
		ford.fusionConfig.maxRadioVolume = config.intValue("maxRadioVolume", 2);
		
		return new TaxiService(ford, config.stringValue("carColor", "white"));
	}
	
	public TaxiDriver createDriver() {
		if (taxiService == null) {
			taxiService = createTaxiService();
		}
		return new TaxiDriver(taxiService);
	}
	
}
