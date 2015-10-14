package com.gut.waniusza.semestr_5.progWspol.lesson_3;

public class HelloThread extends Thread {

    int index;

    public HelloThread(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println("Hello from thread " + index);
    }
}
