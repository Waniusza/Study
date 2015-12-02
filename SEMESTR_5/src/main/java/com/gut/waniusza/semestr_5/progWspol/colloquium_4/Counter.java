package com.gut.waniusza.semestr_5.progWspol.colloquium_4;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author student
 */
public class Counter extends ReentrantLock {
    private int count = 0;
    public void increase() {
        count++;
    }
    public int getCount() {
        
        return count;
    }
}
