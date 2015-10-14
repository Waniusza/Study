package com.gut.waniusza.semestr_5.progWspol.colloquium_1;

public class Message extends Thread {

    public void sayDzienDobry() {
        System.out.println("Dzien Dobry");
    }

    public void run() {

        sayDzienDobry();

    }

}

