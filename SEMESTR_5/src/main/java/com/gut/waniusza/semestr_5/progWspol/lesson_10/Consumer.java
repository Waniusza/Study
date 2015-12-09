package com.gut.waniusza.semestr_5.progWspol.lesson_10;

import static java.lang.Thread.sleep;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread {

    private BlockingQueue<Integer> queue;
    private final int numberToConsume;
    private final int consumerNumber;

    public Consumer(BlockingQueue<Integer> queue, int numberToConsume, int consumerNumber) {
        this.queue = queue;
        this.numberToConsume = numberToConsume;
        this.consumerNumber = consumerNumber;
    }

    @Override
    public void run() {
        try {
            while (!queue.isEmpty()) {
                Integer x;
                x = queue.take();
                consume(x);
            }
        } catch (InterruptedException e) {
        }
    }

    private void consume(Integer x) {
        System.out.println(" == " + consumerNumber + " consuming " + x);
        try {
            sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
