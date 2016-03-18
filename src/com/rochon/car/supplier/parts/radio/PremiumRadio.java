package com.rochon.car.supplier.parts.radio;

public class PremiumRadio implements Radio {

	private final int maxVolume;
	
	private int volume = 0;
	
	public PremiumRadio(int maxVolume) {
		this.maxVolume = maxVolume;
	}
	
	public void on() {
		System.out.println("Radio on ... lalalala lala ...");
	}
	
	public void off() {
		volume = 0;
		System.out.println("... lalala. Radio off.");
	}

	@Override
	public void volumeUp() {
		if (volume == maxVolume) { return; }
		
		volume++;
		volumeAdjusted();
	}

	@Override
	public void volumeDown() {
		if (volume == 0) { return; }
		
		volume--;
		volumeAdjusted();
	}

	private void volumeAdjusted() {
		if (volume < 2) {
			System.out.println("... la la la ...");
		} else if (volume < 4) {
			System.out.println("... La La La ...");
		} else {
			System.out.println("... LA LA LA ...");
		}
	}


}
