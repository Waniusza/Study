/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.progWspol;

import com.gut.waniusza.semestr_5.progWspol.lesson_1.Ex1;
import com.gut.waniusza.semestr_5.progWspol.lesson_1.SomeThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author janusz
 */
public class Runner {
    
    private static final Logger log = LogManager.getLogger(Runner.class);
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        log.debug(" init ");
        Ex1 ex1 = new Ex1();
        SomeThread someThread = new SomeThread();
        // Lesson 1
        ex1.run();
        someThread.run();
    }
    
}
