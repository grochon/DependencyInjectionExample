package com.rochon.car.supplier.parts.radio;

public class BaseRadio implements Radio {

	private final int maxVolume;
	
	private int volume = 0;
	
	public BaseRadio(int maxVolume) {
		this.maxVolume = maxVolume;
	}
	
	public void on() {
		System.out.println("Radio on ... hmm hmm hmm hmm ...");
	}
	
	public void off() {
		volume = 0;
		System.out.println("... hmm hmm. Radio off.");
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
			System.out.println("... hmm hmm hmm ...");
		} else if (volume < 4) {
			System.out.println("... Hmm Hmm Hmm ...");
		} else {
			System.out.println("... HMM HMM HMM ...");
		}
	}
	
}
