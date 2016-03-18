package com.rochon.car.manufacturer.ford;

import com.rochon.car.manufacturer.ford.focus.FordFocusCar;
import com.rochon.car.manufacturer.ford.fusion.FordFusionCar;

public interface FordFactory {

	FordFocusCar createFocus(String color);

	FordFusionCar createFusion(String color, EngineOption engineType);

	public static enum EngineOption {
		FOUR_CYL, SIX_CYL;
	}

}