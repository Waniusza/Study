package com.gut.waniusza.semestr_5.progWspol.lesson_8;

public class DiningPhilosophers {
	public static void main(String[] args) throws InterruptedException {
		int NUMBER_OF_PHILOSOPHERS = 5;
		Philosopher[] philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];
		Chopstick[] chopsticks = new Chopstick[NUMBER_OF_PHILOSOPHERS];
		
		for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
		      chopsticks[i] = new Chopstick();
		}

		for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
			int leftNumber = i;
			int rightNumber = (i+1) % NUMBER_OF_PHILOSOPHERS;

			philosophers[i] = new Philosopher(chopsticks[leftNumber], chopsticks[rightNumber]);
			philosophers[i].start();
		}
		
		for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
			philosophers[i].join();
		}
	}
}
