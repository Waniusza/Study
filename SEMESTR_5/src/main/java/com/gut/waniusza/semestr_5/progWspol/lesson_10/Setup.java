package com.gut.waniusza.semestr_5.progWspol.lesson_10;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Setup {

    public static void main(String[] args) {
        int myCapacity = 20;
        BlockingQueue<Double> myQueue = new ArrayBlockingQueue<>(myCapacity);

        int numberOfProducers = 10, toProduce = 10;
        int numberOfConsumers = 5;
        Producer[] prods = new Producer[numberOfProducers];
        Consumer[] cons = new Consumer[numberOfConsumers];

        for (int i = 0; i < numberOfProducers; i++) {
            prods[i] = new Producer(myQueue, toProduce, i);
            prods[i].start();
        }

        for (int i = 0; i < numberOfConsumers; i++) {
            cons[i] = new Consumer(myQueue, i);
            cons[i].start();
        }

        try {
            for (int i = 0; i < numberOfProducers; i++) {
                prods[i].join();
            }

            for (int i = 0; i < numberOfConsumers; i++) {
                cons[i].join();
            }
        } catch (InterruptedException e) {
        }

        System.out.println("All done! Good bye!");
    }

}
