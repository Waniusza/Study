package com.gut.waniusza.semestr_5.progWspol.lesson_10;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Setup {

	public static void main(String[] args) {
		int myCapacity = 40;
		BlockingQueue<Integer> myQueue = new ArrayBlockingQueue<Integer>(myCapacity);
		
		int numberOfProducers = 10, toProduce = 4;
		int numberOfConsumers = 2, toConsume = 8;
		Producer[] prods = new Producer[numberOfProducers];
		Consumer[] cons = new Consumer[numberOfConsumers];

		for (int i=0; i<numberOfProducers; i++) {
			prods[i] = new Producer(myQueue, toProduce, i);
			prods[i].start();
		}
		
		for (int i=0; i<numberOfConsumers; i++) {
			cons[i] = new Consumer(myQueue,toConsume, i);
			cons[i].start();
		}
		

		try {
			for (int i=0; i<numberOfProducers; i++) {
				prods[i].join();
			}
			for (int i=0; i<numberOfConsumers; i++) {
				cons[i].join();
			}
		} catch (InterruptedException e) { }
		
		System.out.println("All done! Good bye!");
	}

}
