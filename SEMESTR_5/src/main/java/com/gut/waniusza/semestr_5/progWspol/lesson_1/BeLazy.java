/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.progWspol.lesson_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class BeLazy {
    public static void doNothingForOneSecond() {
        try {
            Thread.sleep( 200 );
        } catch (InterruptedException ex) {
            System.out.println("BLAD InterruptedException " + ex);
//            Logger.getLogger(BeLazy.class.getName()).log(Level.WARNING, null, ex);
        } catch (Exception ex) {
            System.out.println("BLAD " + ex);
        }
    }
    
}
