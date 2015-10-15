/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.progWspol.lesson_3;

/**
 *
 * @author student
 */
public class CountingThread extends Thread {

    Counter counter;

    public CountingThread(Counter c) {
        this.counter = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}
