/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.progWspol.lesson_3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Counting {

    public static void main(String[] args) {
        Counter mCounter = new Counter();

        CountingThread t1 = new CountingThread(mCounter);
        CountingThread t2 = new CountingThread(mCounter);

        try {
            t1.start();
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Counting.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            t2.start();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Counting.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("The couner is now: " + mCounter.getCount());
    }

}
