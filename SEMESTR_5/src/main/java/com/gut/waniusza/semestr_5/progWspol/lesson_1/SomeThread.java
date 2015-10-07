/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.progWspol.lesson_1;

/**
 *
 * @author student
 */
public class SomeThread {

    public void run() {

        ABCThread t1 = new ABCThread();
        ABCThread t2 = new ABCThread();

        t1.start();
        t2.start();
    }
}
