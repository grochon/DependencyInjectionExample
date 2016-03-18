package com.rochon.car.supplier.parts.horn;

public class Horn {

	private int volume;
	
	public Horn(int volume) {
		this.volume = volume;
	}
	
	public void honk() {
		if (volume < 80) {
			System.out.println("honk.");
		} else if (volume < 90) {
			System.out.println("Honk!");
		} else if (volume < 95) {
			System.out.println("HONK!");
		} else {
			System.out.println("HONK!!!");
		}
	}
	
}
