package com.gut.waniusza.semestr_5.progWspol.lesson_4.bankingProblem.dinner;

public class MoneyTransfer1 extends Thread {

    private BankAccount accountFROM;
    private BankAccount accountTO;
    private double amount;

    public MoneyTransfer1(BankAccount accountFROM,
            BankAccount accountTO, double amount) {
        this.accountFROM = accountFROM;
        this.accountTO = accountTO;
        this.amount = amount;
    }

    private void transfer() {
        synchronized (accountFROM) {
            synchronized (accountTO) {
                double balanceFROM = accountFROM.balance - amount;
                try {
                    sleep((int) (Math.random() * 100));
                } catch (InterruptedException e) {
                }
                double balanceTO = accountTO.balance + amount;
                try {
                    sleep((int) (Math.random() * 100));
                } catch (InterruptedException e) {
                }
                accountFROM.balance = balanceFROM;
                accountTO.balance = balanceTO;
            }
        }
    }

    public void run() {
        transfer();
    }
}
