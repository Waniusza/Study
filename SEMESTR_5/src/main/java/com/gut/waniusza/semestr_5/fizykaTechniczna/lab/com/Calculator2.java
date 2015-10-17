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
public class Calculator2 extends Thread {

    static int szer;
    static int wys;

    static int scr[][];

    public Calculator2(int szer, int wys, int old[][]) {
        this.szer = szer;
        this.wys = wys;
        scr = old;
    }

    static void calc() {
        for (int y = 0; y <= wys - 3; y++) {
            int current[] = scr[y];
            int lowwer[] = scr[y + 1];
            int dlowwer[] = scr[y + 2];

            for (int x = 2; x < szer - 3; x++) {
                int tmp;
                double wspl = 1 - Math.abs(x - (double) (szer) / 2) / (szer / 2);
                /*20*/ tmp = (int) current[x - 1] * 10 + current[x + 1] * 10;
                /*30*/ tmp += (int) (lowwer[x - 1] * 15 * (1 - wspl) + lowwer[x] * 30 * wspl + lowwer[x + 1] * 15 * (1 - wspl));
                /*76*/tmp += (dlowwer[x - 2] * 30 * (1 - wspl) + dlowwer[x - 1] * 8 + dlowwer[x] * 60 * wspl + dlowwer[x + 1] * 8 + dlowwer[x + 2] * 30 * (1 - wspl));
                tmp /= 126;
                scr[y][x] = tmp;
            }
        }
    }

    public static int[][] getScr() {
        return scr;
    }

    @Override
    public void run() {
        calc();
    }
}
