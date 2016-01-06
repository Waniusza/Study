package com.gut.waniusza.semestr_5.progWspol.lesson_10;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {

    private BlockingQueue<Double> queue;
    private final int consumerNumber;
    
    public Consumer(BlockingQueue<Double> queue, int consumerNumber) {
        this.queue = queue;
        this.consumerNumber = consumerNumber;
    }

    @Override
    public void run() {
        try {
            while (!queue.isEmpty()) {
                Double x;
                x = queue.poll(5, TimeUnit.SECONDS);
                consume(x);
            }
        } catch (InterruptedException e) {
        }
    }

    private void consume(Double x) {
        System.out.println(" == " + consumerNumber + " consuming " + x);
    }
}
