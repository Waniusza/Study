package com.gut.waniusza.semestr_5.progWspol.lesson_10;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread {
	private final BlockingQueue<Integer> queue;
	private final int numberToProduce;
        private final int produceNumber;
	private Integer productId = 0;

	public Producer(BlockingQueue<Integer> queue, int numberToProduce, int produceNumber) {
		this.queue = queue;
		this.numberToProduce = numberToProduce;
                this.produceNumber = produceNumber;
	}

	@Override
	public void run() {
		try {
			for (int i=0; i<numberToProduce; i++) {
				Integer x = produce();
				queue.put(x);
			}
		} catch (InterruptedException ex) { }
	}
	
	private Integer produce() {
		Integer x = productId;
		productId++;
		System.out.println(produceNumber + " producing " + x);
           
		return x;
	}
}
