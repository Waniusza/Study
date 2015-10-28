package com.gut.waniusza.semestr_5.progWspol.lesson_5;

public class PCTest3 {

	public static void main(String[] args) {
		DeadValue v = new DeadValue();
		Producer p1 = new Producer(v,"p1");
		Consumer c1 = new Consumer(v,"c1");
		p1.start();
		c1.start();
	}

}
