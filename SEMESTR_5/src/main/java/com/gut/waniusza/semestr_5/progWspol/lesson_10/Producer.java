package com.gut.waniusza.semestr_5.progWspol.lesson_10;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer extends Thread {

    private Random generato = new Random();
    private final BlockingQueue<Double> queue;
    private final int numberToProduce;
    private final int produceNumber;

    public Producer(BlockingQueue<Double> queue, int numberToProduce, int produceNumber) {
        this.queue = queue;
        this.numberToProduce = numberToProduce;
        this.produceNumber = produceNumber;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numberToProduce; i++) {
                Double x = produce();
                queue.offer(x, 5, TimeUnit.SECONDS);
            }
        } catch (InterruptedException ex) {
        }
    }

    private Double produce() {
        Double x = generato.nextDouble();
        System.out.println(produceNumber + " producing " + x);
        return x;
    }
}
