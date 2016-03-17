package com.rochon.car.app.common;

public class NullAppConfig implements AppConfig {

	@Override
	public double doubleValue(String name, double defaultValue) {
		return defaultValue;
	}

	@Override
	public String stringValue(String name, String defaultValue) {
		return defaultValue;
	}

	@Override
	public int intValue(String name, int defaultValue) {
		return defaultValue;
	}

}
