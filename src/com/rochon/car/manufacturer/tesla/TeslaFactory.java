package com.rochon.car.manufacturer.tesla;

import com.rochon.car.manufacturer.tesla.modelS.TeslaModelSCar;

public interface TeslaFactory {

	TeslaModelSCar createModelS(String color);

}