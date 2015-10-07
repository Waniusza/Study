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
public class ABCThread extends Thread {

    public void run() {
        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.print(i);
            System.out.flush();

//            Logger.getLogger(ABCThread.class.getName()).log(Level.INFO, null, i);
            BeLazy.doNothingForOneSecond();
        }
    }
}

/**
 * When you write data out to a stream, some amount of buffering will occur, and
 * you never know for sure exactly when the last of the data will actually be
 * sent. You might perform many operations on a stream before closing it, and
 * invoking the flush() method guarantees that the last of the data you thought
 * you had already written actually gets out to the file.
 */
