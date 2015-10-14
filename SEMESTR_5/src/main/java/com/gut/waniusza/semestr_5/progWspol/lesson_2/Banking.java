package com.gut.waniusza.semestr_5.progWspol.lesson_2;


/**
 *
 * @author student
 */
public class Banking {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Bank myBank = new Bank(100);

        int numberOfClerks = 3;
        Clerk[] myClerk = new Clerk[numberOfClerks];
        for (int i = 0; i < numberOfClerks; i++) {
            myClerk[i] = new Clerk(myBank, 10000);
        }

        for (int i = 0; i < numberOfClerks; i++) {
            myClerk[i].start();
        }

        double moneyInBank = myBank.getTotalBalance();
        System.out.println("Money in the bank: " + moneyInBank);

        double moneyTransfered = 0;
        for (int i = 0; i < numberOfClerks; i++) {
            moneyTransfered += myClerk[i].getTotalAmount();
        }
        System.out.println("Money transfered: " + moneyTransfered);

        double moneyMissing = moneyInBank - moneyTransfered;
        System.out.println("Difference: " + moneyMissing);
    }
}
