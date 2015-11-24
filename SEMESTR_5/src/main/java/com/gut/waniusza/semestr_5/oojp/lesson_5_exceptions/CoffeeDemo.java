package com.gut.waniusza.semestr_5.oojp.lesson_5_exceptions;

public class CoffeeDemo {

	public static void main(String[] args) {
		CoffeePot pot = new CoffeePot(800);
		CoffeeCup cup = new CoffeeCup(200);
		
		int amount = 150;
		try {
			pot.fillCup(cup, amount);
		} catch (CupWillRunOverException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (CupNotEmptyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		
		try {
			pot.fillCup(cup, amount);
		} catch (CupWillRunOverException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (CupNotEmptyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		amount = 400;
		cup.setVolume(0);
		try {
			pot.fillCup(cup, amount);
		} catch (CupWillRunOverException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (CupNotEmptyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("OK, take care!");

	}

}
