package com.gut.waniusza.semestr_5.oojp.lesson_5_exceptions;


public class CoffeePot {
	int volume;
	
	public CoffeePot(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "CoffeePot [volume=" + volume + "]";
	}

	void fillCup(CoffeeCup cup, int amount) 
			throws CupWillRunOverException, CupNotEmptyException {
		
		System.out.println("I try to fill in " + amount + " ml.");
		if (cup.getVolume() > 0) {
			throw new CupNotEmptyException();
		}

		int amountForCup = 0;
		if (this.volume < amount) {
			amountForCup = this.volume;
		}
		else {
			amountForCup = amount;
		}

		if (amountForCup > cup.getCapacity()) {
			throw new CupWillRunOverException();
		}
		
		int newVolume = cup.getVolume() + amountForCup;
		cup.setVolume(newVolume);
		this.volume = this.volume - amountForCup;

		System.out.println("I have filled " + amountForCup + " ml into the cup.");
		System.out.println(this);
		System.out.println(cup);
	}

}
