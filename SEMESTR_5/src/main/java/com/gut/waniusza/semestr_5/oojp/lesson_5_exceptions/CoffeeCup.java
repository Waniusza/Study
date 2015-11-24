package com.gut.waniusza.semestr_5.oojp.lesson_5_exceptions;

public class CoffeeCup {
	private int capacity;
	private int volume;

	CoffeeCup(int capacity) {
		this.capacity = capacity;
		this.volume = 0;
	}

	@Override
	public String toString() {
		return "CoffeeCup [capacity=" + capacity + ", volume=" + volume + "]";
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

}
