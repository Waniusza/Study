package com.gut.waniusza.semestr_5.progWspol.colloquium_3_online.result;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author janusz
 */
public class MyFunction extends Thread {

    private Sum s;
    private double x;

    public void setReady(double x, Sum s) {
        this.s = s;
        this.x = x;
    }

    public void calcAndAddToSum() {
        System.out.println(" calc MyFunction " + x);
        double y = 1.0 / Math.exp(x);
        synchronized (s) {
            s.sum += y;
        }
        try {
            sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(" calced MyFunction " + x);
    }

    public void run() {
        calcAndAddToSum();
    }
}
