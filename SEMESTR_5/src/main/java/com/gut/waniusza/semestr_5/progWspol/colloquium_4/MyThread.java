package com.gut.waniusza.semestr_5.progWspol.colloquium_4;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class MyThread extends Thread {
    Counter myCounter;

    public MyThread(Counter myCounter) {
        this.myCounter = myCounter;
    }
    public void run() {
        Boolean counted = Boolean.FALSE;
        while (!counted) {
            try {
                if (myCounter.tryLock(0, TimeUnit.MILLISECONDS)) {
                    myCounter.increase();
                    myCounter.unlock();
                    counted = Boolean.TRUE;
                } else {
                    // didn't count, try again
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
