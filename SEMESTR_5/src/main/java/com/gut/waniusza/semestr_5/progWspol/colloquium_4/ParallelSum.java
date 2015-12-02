
package com.gut.waniusza.semestr_5.progWspol.colloquium_4;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author student
 */
public class ParallelSum {
    public static void main(String[] args) {
        final Counter myCounter = new Counter();
        int nThreads = 1000;
        MyThread[] t = new MyThread[nThreads];
        
        for (int i=0; i<nThreads; i++) {
            t[i] = new MyThread(myCounter);
            t[i].start();
        }
        try {
            for (int i=0; i<nThreads; i++) {
                t[i].join(); 
            }
        }
        catch (InterruptedException e) { }
        System.out.println("The sum is " + myCounter.getCount());
    }
}