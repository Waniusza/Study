package com.gut.waniusza.semestr_5.progWspol.lesson_8;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher extends Thread {

    private Chopstick left, right;
    private Random random;
    private int thinkCount;

    private void think() throws InterruptedException {
        Thread.sleep(200);     // Think for a while
    }

    private void eat() throws InterruptedException {
        Thread.sleep(200);     // Eat for a while
    }

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
        this.random = new Random();
        this.thinkCount = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Long startTime = System.currentTimeMillis();
                ++thinkCount;
                this.think(); // think for a while
                try {
                    left.lock();  // grab left chopstick 
                    if (right.tryLock(1, TimeUnit.MILLISECONDS)) { // grab right chopstick 
                        try {
                            this.eat(); // eat for a while
                        } finally {
                            right.unlock();
                        }
                    } else {
						// didn't get the right chopstick;
                        // put down the left chopstick and think again
                    }
                } finally {
                    left.unlock();
                }
                if (thinkCount % 3 == 0) {
                    System.out.println("Philosopher " + this + " has thought " + thinkCount + " times. Last time he waits: " + (System.currentTimeMillis() - startTime));
                }

            }
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }
}
