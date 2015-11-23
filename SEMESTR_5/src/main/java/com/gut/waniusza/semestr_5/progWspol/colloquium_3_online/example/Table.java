package com.gut.waniusza.semestr_5.progWspol.colloquium_3_online.example;

public class Table {
	private boolean[] chopStickUsed;
	
	public Table(int numberOfChopSticks) {
		chopStickUsed = new boolean[numberOfChopSticks];
		for (int i = 0; i < chopStickUsed.length; i++) {
			chopStickUsed[i] = false;
		}
	}
	
	private int left(int i) {
		return i;
	}
	
	private int right(int i) {
		int n = i+1;;
		if (n >= chopStickUsed.length) {
			n = 0;
		}
		System.out.println("use chopstick " + n);
		return n;
	}
	
	public synchronized void takeChopStick(int i) {
		while (chopStickUsed[left(i)] || chopStickUsed[right(i)]) {
			try {
				wait();
			}
			catch (InterruptedException e) { }
			chopStickUsed[left(i)] = true;
			chopStickUsed[right(i)] = true;
		}
	}
	
	public synchronized void putChopStick(int i) {
		chopStickUsed[left(i)] = false;
		chopStickUsed[right(i)] = false;
		notifyAll();
	}
}
