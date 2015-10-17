/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author janusz
 */
public class Drawer extends Thread {

    Graphics mapa;
    int scr[][];
    int szer, wys;


    public Drawer(Graphics mapa, int[][] scr, int szer, int wys) {
        this.mapa = mapa;
        this.scr = scr;
        this.szer = szer;
        this.wys = wys;
    }
    

    private void draw() {
        int tmp;
        for (int y = 0; y <= wys - 3; y++) {
            for (int x = 1; x < szer - 2; x++) {
                int lowwer[] = scr[y + 1];
                int dlowwer[] = scr[y + 2];

                tmp = (lowwer[x] * 20 + lowwer[x + 1] * 7 + lowwer[x - 1] * 7);
                tmp += (dlowwer[x] * 14 + dlowwer[x + 1] * 6 + dlowwer[x - 1] * 6);
                tmp /= 60;
                piksel(x, y, tmp - 5);
//                System.out.println("tmp -> " + tmp);
            }

        }
    }
    
    @Override
    public void run() {
        draw();
    }

    void piksel(int x, int y, int kolor) {
        if (x > 0 && x < 300 && y > 0 && y < 200) {
            if (kolor > 0 && kolor < 255) {
                scr[y][x] = kolor;
                mapa.setColor(new Color(255, 255 - kolor, 0));
            } else if (kolor <= 0) {
                scr[y][x] = 0;
                mapa.setColor(new Color(0, 0, 0));
            } else {
                scr[y][x] = 0;
                mapa.setColor(new Color(0, 0, 0));
            }
            mapa.drawRect(x, y, 1, 1);
        }
    }

}
