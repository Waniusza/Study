package com.gut.waniusza.semestr_5.progWspol.lesson_5;

public class GoodValue extends Value {
	private boolean available = false;
	public synchronized int get() {
		if (!available) {
			try {
				wait();
			}
			catch (InterruptedException e) {
			}
		}
		available = false;
		notify();
		return value;
	}
	public synchronized void put (int v) {
		if (available) {
			try {
				wait();
			}
			catch (InterruptedException e) {
			}
		}
		value = v;
		available = true;
		notify();
	}
}
