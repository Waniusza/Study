/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.fizykaTechniczna.lab;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * 
 * http://lo28.internetdsl.pl/kolor/ogien.htm
 * @author janusz
 */
public class FireAlgorithm extends Applet {

    int wys = 200;
    int szer = 300;
    Graphics mapa;

    int scr[][] = new int[wys][szer];
    int pal[] = new int[szer];

    @Override
    public void paint(Graphics g) {
        mapa = g;
        fire_g();
    }

    public void init() {
        paleta();
    }

    void genPalet() {
        pal[0] = 0;
        for (int i = 1; i < szer; i++) {
            pal[i] = 150 + (int) (Math.random() * 106);
        }
    }

    void paleta() {
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 300; j++) {
                scr[i][j] = 0;
            }
        }
        genPalet();
    }

    void piksel(int x, int y, int kolor) {
        if (x > 0 && x < 300 && y > 0 && y < 200) {
            if (kolor > 0 && kolor < 255) {
                mapa.setColor(new Color(kolor, 0, 0));
            } else if (kolor <= 0) {
                mapa.setColor(new Color(0, 0, 0));
            } else {
                mapa.setColor(new Color(255, 0, 0));
            }
            mapa.drawRect(x, y, 1, 1);
            scr[y][x] = kolor;
        }
    }

    void fire_g() {
        int tmp;
        genPalet();
        for (int x = 1; x < szer; x++) {
            piksel(x, 199, pal[x]); /**/

            piksel(x, 200, pal[x]); /**/

        }
        for (int y = wys - 3; y > 0; y--) {
            for (int x = 1; x < szer - 2; x++) {
                int lowwer[] = scr[y + 1];
                int dlowwer[] = scr[y + 2];

                tmp = (lowwer[x] * 20 + lowwer[x + 1] * 7 + lowwer[x - 1] * 7);
                tmp += (dlowwer[x] * 14 + dlowwer[x + 1] * 6 + dlowwer[x - 1] * 6);
                tmp /= 60;
                piksel(x, y, tmp);
            }

        }

        fire_g();
    }

}
