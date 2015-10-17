/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author janusz
 */
public class Calculator extends Thread {

    static int szer;
    static int[] res;

    public Calculator(int szer) {
        this.szer = szer;
        this.res = new int[szer];
    }

    static void genPalet() {
        for (int i = 10; i < szer - 10; i++) {
            double wsp = 1 - Math.abs(i - (double)(szer/2))/(szer/2);
            res[i] = (int) (Math.random() * 126 + 126 * wsp);
        }
    }

    public static int[] getRes() {
        return res;
    }

    @Override
    public void run() {
        genPalet();
    }

}
