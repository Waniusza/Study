package com.gut.waniusza.semestr_5.progWspol.lesson_2;

/**
 *
 * @author student
 */
public class Bank {
    private final int numberOfAccounts;
    private Account[] accounts;
    
    public Bank(int numberOfAccounts) {
        this.numberOfAccounts = numberOfAccounts;
        accounts = new Account[numberOfAccounts];
        for (int i=0; i< numberOfAccounts; i++) {
            accounts[i] = new Account(0);
        }
    }

    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }
    
    public void transferMoney(int accountNumber, double amount) {
        double oldBalande = accounts[accountNumber].getBalance();
        double newBalande = oldBalande + amount;
        accounts[accountNumber].setBalance(newBalande);
    }
    
    public double getTotalBalance() {
        double totalBalance = 0;
        for (int i=0 ; i<numberOfAccounts; i++) {
            totalBalance += accounts[i].getBalance();
        }
        return totalBalance;
    }
}
