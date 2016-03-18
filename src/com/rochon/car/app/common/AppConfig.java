package com.rochon.car.app.common;

public interface AppConfig {

	double doubleValue(String name, double defaultValue);
	
	String stringValue(String name, String defaultValue);
	
	int intValue(String name, int defaultValue);
	
}
