package com.gut.waniusza.semestr_5.progWspol.colloquium_3_online.example;


public class Dinner {
	private static final int NUMBER = 5;
	
	public static void main(String[] args) {
		Table table = new Table(NUMBER);
		Philosopher[] philosophers = new Philosopher[NUMBER];
		for (int i=0; i<NUMBER; i++) {
			philosophers[i] = new Philosopher(table, i);
		}
	}
}
