package com.rochon.car.supplier.parts.door;

import java.util.Set;

public class PowerDoorLocks {

	private Set<Door> doors;

	public PowerDoorLocks(Set<Door> doors) {
		this.doors = doors;
	}
	
	public void lock() {
		doors.forEach(d -> d.lock());
	}
	
	public void unlock() {
		doors.forEach(d -> d.unlock());
	}
	
}
