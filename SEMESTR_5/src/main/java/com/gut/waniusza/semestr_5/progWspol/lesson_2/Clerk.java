/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.progWspol.lesson_2;

/**
 *
 * @author student
 */
public class Clerk extends Thread {

    private Bank myBank;
    private int numberOfTransfers;
    private double totalAmount;

    public Clerk(Bank myBank, int numberOfTransfers) {
        this.myBank = myBank;
        this.numberOfTransfers = numberOfTransfers;
        totalAmount = 0;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public synchronized void makeTransaction(int naccounts) {
        for (int i = 0; i < numberOfTransfers; i++) {
            int accountNumber = (int) (Math.random() * naccounts);
            double amount = (int) (Math.random() * 100);
            myBank.transferMoney(accountNumber, amount);
            totalAmount += amount;
        }
    }

    @Override
    public void run() {
        int naccounts = myBank.getNumberOfAccounts();
        makeTransaction(naccounts);
    }
}
