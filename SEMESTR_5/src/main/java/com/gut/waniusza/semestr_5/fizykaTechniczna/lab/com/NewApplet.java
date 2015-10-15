/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author janusz
 */
public class NewApplet extends Applet {

    int wys = 200;
    int szer = 300;
    Graphics mapa;

    int scr[][] = new int[wys][szer];
    int newscr[][] = new int[wys][szer];
    int[] pal1 = new int[szer];
    int[] pal2 = new int[szer];

    @Override
    public void paint(Graphics g) {
        mapa = g;
        fire_g();
    }

    public void init() {
        paleta();
    }

    void paleta() {
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 300; j++) {
                scr[i][j] = 0;
            }
        }
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

    void fire_g() {
        int tmp;
        Calculator c1 = new Calculator(szer);
        Calculator c2 = new Calculator(szer);
        c1.start();
        c2.start();

        try {
            c1.join();
            c2.join();
            scr[wys-1] = pal1 = c1.getRes();
            scr[wys-2] = pal2 = c2.getRes();
        } catch (InterruptedException ex) {
            Logger.getLogger(NewApplet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Calculator2 cz1 = new Calculator2(szer, wys, scr);
        
        cz1.start();
        try {
            cz1.join();
            scr = cz1.getScr();
        } catch (InterruptedException ex) {
            Logger.getLogger(NewApplet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
