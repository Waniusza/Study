package com.gut.waniusza.semestr_5.progWspol.lesson_2;

/**
 *
 * @author student
 */
public class Account {

    private double balance;

    public Account() {
        balance = 0;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Balance = " + balance;
    }

}
