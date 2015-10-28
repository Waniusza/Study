package com.gut.waniusza.semestr_5.progWspol.lesson_5;

public class DeadValue extends Value {
	public synchronized int get() {
		try {
			wait();
		}
		catch (InterruptedException e) {
		}
		notify();
		return value;
	}
	public synchronized void put (int v) {
		value = v;
		notify();
		try {
			wait();
		}
		catch (InterruptedException e) {
		}
	}
}