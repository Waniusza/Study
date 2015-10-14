/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.progWspol.lesson_3;

public class HelloProgram {

    public static void main(String args[]) throws InterruptedException {

        int numberOfThreads = 5;
        HelloThread[] hello = new HelloThread[numberOfThreads];

        // create the threads
        for (int i = 0; i < numberOfThreads; i++) {
            hello[i] = new HelloThread(i);
        }

        // start the threads
        hello[0].start();
        for (int i = 1; i < numberOfThreads; i++) {
            hello[i-1].join();
            hello[i].start();
        }
        
        hello[numberOfThreads-1].join();

        System.out.println("Good Bye. Have a nice day! ");
    }
}
