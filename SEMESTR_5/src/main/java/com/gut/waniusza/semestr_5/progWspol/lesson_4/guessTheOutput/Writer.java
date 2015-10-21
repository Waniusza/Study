package com.gut.waniusza.semestr_5.progWspol.lesson_4.guessTheOutput;

public class Writer extends Thread {
	public static void main(String[] args) {
		Thread t = new Writer();
		t.start();
		System.out.print("m1 ");
		try {
			t.join();
		} 
		catch (InterruptedException ex) {}
		System.out.print("m2 ");

	}

	public void run() {
		System.out.print("r1 ");
		System.out.print("r2 ");
	}
}
