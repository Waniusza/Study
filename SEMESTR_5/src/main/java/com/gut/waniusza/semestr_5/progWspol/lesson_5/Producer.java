package com.gut.waniusza.semestr_5.progWspol.lesson_5;

public class Producer extends Thread {
	Value v;
	String Name;
	public Producer(Value v, String Name) {
		this.v = v;
		this.Name = Name;
	}
	public void run() {
		for (int i=0; i<5; i++) {
			v.put(i);
			System.out.println("Producer " + Name + " puts: " + i);
			try {
				sleep((int) (Math.random()*100));
			}
			catch (InterruptedException e) {
				
			}
		}
	}
}

