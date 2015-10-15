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
public class Calculator2 extends Thread{

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
            int lowwer[] = scr[y + 1];
            int dlowwer[] = scr[y + 2];

            for (int x = 1; x < szer - 2; x++) {
                int tmp;
                tmp = (lowwer[x] * 20 + lowwer[x + 1] * 7 + lowwer[x - 1] * 7);
                tmp += (dlowwer[x] * 14 + dlowwer[x + 1] * 6 + dlowwer[x - 1] * 6);
                tmp /= 60;
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
