package com.rochon.car.supplier.parts.door;

public class Door {

	private String name;
	private String color;
	private double windowSpeed;
	
	public Door(String name, String color, double windowSpeed) {
		this.name = name;
		this.color = color;
		this.windowSpeed = windowSpeed;
	}
	
	public void lock() {
		System.out.println(String.format("Door %s locked.", name));
	}
	
	public void unlock() {
		System.out.println(String.format("Door %s unlocked.", name));
	}
	
	public void rollUpWindow() {
		System.out.println(String.format("Window %s is up."));
	}
	
	public void rollDownWindow() {
		System.out.println(String.format("Window %s is down."));
	}
	
}
