package com.gut.waniusza.semestr_5.progWspol.colloquium_3_online.result;

import java.util.*;

/**
 *
 * @author janusz
 */
public class SequentialSum {

    public static void main(String[] args) throws InterruptedException {
        int nThreads = 100;
        Sum s = new Sum();
        LinkedList<MyFunction> mfList = new LinkedList<MyFunction>();
        for (int i = 0; i < nThreads; i++) {
            MyFunction myf = new MyFunction();
            mfList.add(myf);
        }
        System.out.println("number of threads " + mfList.size());
        int i = 0;
        for (MyFunction el : mfList) {
            System.out.println(" run MyFunction " + i);
            el.setReady((double) i, s);
            el.start();
            i++;
        }

        for (MyFunction el : mfList) {
            el.join();
        }
        System.out.println("The sum is " + s.sum);
    }
}
