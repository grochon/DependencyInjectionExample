package com.rochon.car.app.dealer;

import static com.rochon.car.manufacturer.ford.FordFactory.EngineOption.SIX_CYL;

import com.rochon.car.manufacturer.ford.FordFactory;
import com.rochon.car.manufacturer.ford.focus.FordFocusCar;
import com.rochon.car.manufacturer.ford.fusion.FordFusionCar;
import com.rochon.car.manufacturer.tesla.TeslaFactory;
import com.rochon.car.manufacturer.tesla.modelS.TeslaModelSCar;

public class Showroom {

	private final FordFactory ford;
	private final TeslaFactory tesla;
	
	private FordFocusCar fordFocus;
	private FordFusionCar fordFusion;
	private TeslaModelSCar teslaModelS;
	
	public Showroom(FordFactory ford, TeslaFactory tesla) {
		this.ford = ford;
		this.tesla = tesla;
	}
	
	public static void main(String[] args) {
		Showroom showroom = DealerFactory.createShowroom();
		showroom.restock();
		showroom.demoTeslaModelS();
	}
	
	public void restock() {
		fordFocus = ford.createFocus("blue");
		fordFusion = ford.createFusion("silver", SIX_CYL);
		teslaModelS = tesla.createModelS("red");
	}
	
	public void demoFordFocus() {
		say("Let's check out the Ford Focus.");
		fordFocus.unlockDoors();
		fordFocus.radio().on();
		fordFocus.radio().volumeUp();
		fordFocus.radio().volumeUp();
		say("You can control it from the steering wheel too ...");
		fordFocus.steeringWheel().volumeDown();
		fordFocus.radio().off();
		fordFocus.lockDoors();
	}
	
	public void demoFordFusion() {
		say("Come look at the Fusion!");
		fordFusion.unlockDoors();
		say("It's got all weather tires ...");
		fordFusion.radio().on();
		say("And check out the premium sound package!");
		fordFusion.steeringWheel().volumeUp();
		fordFusion.steeringWheel().volumeUp();
		fordFusion.steeringWheel().volumeUp();
		fordFusion.steeringWheel().volumeUp();
		fordFusion.steeringWheel().volumeUp();
		say("IT FEELS LIKE YOU'RE THERE, RIGHT?");
		fordFusion.radio().off();
		fordFusion.lockDoors();
	}
	
	public void demoTeslaModelS() {
		say("Now this baby is really sweet, get in!");
		teslaModelS.unlockDoors();
		teslaModelS.radio().on();
		say("Here we go.");
		teslaModelS.accelerate(0.5);
		say("It's got an autopilot mode ...");
		teslaModelS.enableAutopilot();
		say("Look! No hands!");
		teslaModelS.steeringWheel().honk();
		say("Woo!");
		teslaModelS.disableAutopilot();
		teslaModelS.brake(1.0);
		say("Ride's over.");
		teslaModelS.lockDoors();
	}
	
	private void say(String message) {
		System.out.println("Dealer: \"" + message + "\"");
	}
}
