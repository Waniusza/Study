package com.gut.waniusza.semestr_5.progWspol.lesson_5;

public class PCTest5 {

	public static void main(String[] args) {
		BetterValue v = new BetterValue();
		Producer p1 = new Producer(v,"p1");
		Producer p2 = new Producer(v,"p2");
		Producer p3 = new Producer(v,"p3");
		Consumer c1 = new Consumer(v,"c1");
		Consumer c2 = new Consumer(v,"c2");
		Consumer c3 = new Consumer(v,"c3");
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		c3.start();
	}

}
