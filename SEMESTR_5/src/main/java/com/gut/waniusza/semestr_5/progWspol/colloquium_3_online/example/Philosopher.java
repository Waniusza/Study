package com.gut.waniusza.semestr_5.progWspol.colloquium_3_online.example;

public class Philosopher extends Thread {
	private Table table;
	private int number;

	public Philosopher(Table table, int number) {
		this.table = table;
		this.number = number;
		this.start();
	}
	
	public void run() {
		while(true) {
			think();
			table.takeChopStick(number);
			eat();
			table.putChopStick(number);
		}
	}

	private void think() {
		System.out.println("Philosopher " + number + " is thinking.");
		try {
			sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {}
	}

	private void eat() {
		System.out.println("Philosopher " + number + " is starting to eat.");
		try {
			sleep((long) (Math.random() * 2000));
		} catch (InterruptedException e) {}
		System.out.println("Philosopher " + number + " finished eating.");
	}

}
