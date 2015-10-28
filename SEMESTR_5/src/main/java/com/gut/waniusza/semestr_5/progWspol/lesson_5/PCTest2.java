package com.gut.waniusza.semestr_5.progWspol.lesson_5;

public class PCTest2 {

	public static void main(String[] args) {
		GoodValue v = new GoodValue();
		Producer p1 = new Producer(v,"p1");
		Consumer c1 = new Consumer(v,"c1");
		p1.start();
		c1.start();
	}

}
