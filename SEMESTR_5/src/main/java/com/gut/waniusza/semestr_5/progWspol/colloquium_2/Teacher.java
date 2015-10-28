package com.gut.waniusza.semestr_5.progWspol.colloquium_2;

/**
 *
 * @author waniusza
 */
public class Teacher extends Thread {

    private static int counter = 0;

    public void run() {
        for (int i = 0; i < 50; ++i) {
            increaseCounter();
        }
    }

    public void increaseCounter() {
        ++counter;
    }

    public static int getCounter() {
        return counter;
    }

}
