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

    int[][] scrRed = new int[wys][szer];
    int[][] scrGreen = new int[wys][szer];
    int[] redPal = new int[szer];
    int[] greenPal = new int[szer];

    @Override
    public void paint(Graphics g) {
        mapa = g;
        fire_g();
    }

    public void init() {
        paleta();
    }

    void genPalet() {
        for (int i = 1; i < szer; i++) {
            redPal[i] = 184 + (int) (Math.sin(Math.random()) * 64);
            greenPal[i] +=  20 + (int) (Math.sin(Math.random()) * 16);
        }
    }

    void paleta() {
        for (int i = 1; i < szer; i++) {
            redPal[i] = 128 + (int) (Math.random() * 128);
            greenPal[i] = 20 + (int) (Math.random() * 128);
        }
//       
//        for (int i = 1; i < 128; i++) {
//            redPal[i] = (2 * i << 16) | (i << 8) | (2);
//        }
//        for (int i = 0; i < 64; i++) {
//            redPal[i + 128] = (254 << 16) | (i + 127 << 8) | (i + 2);
//        }
//        for (int i = 0; i < 66; i++) {
//            redPal[i + 190] = (254) | (i + 190 << 8) | (i + 65);
//        }
//        redPal[0] = 0;
//        redPal[1] = 0;
//        redPal[255] = (255 << 16) | (255 << 8) | (132);
    }

    void piksel(int x, int y, int red, int green) {
        if (red > 0 && green > 0 && red < 255 & green < 255) {
            mapa.setColor(new Color(red, green, 0));
            scrRed[y][x] = red;
            scrGreen[y][x] = green;
        } else if (red <= 0 && green > 0) {
            mapa.setColor(new Color(0, green, 0));
            scrRed[y][x] = 0;
            scrGreen[y][x] = green;
        } else if (red > 0 && green <= 0) {
            mapa.setColor(new Color(red, 0, 0));
            scrRed[y][x] = red;
            scrGreen[y][x] = 0;
        } else if (red <= 0 && green <= 0) {
            mapa.setColor(new Color(0, 0, 0));
            scrRed[y][x] = 0;
            scrGreen[y][x] = 0;
        }
        mapa.drawRect(x, y, 1, 1);
    }

    void fire_g() {
        genPalet();

        int tmpRed[] = new int[szer];
        int tmpGreen[] = new int[szer];
        for (int x = 10; x < szer - 10; x++) {
            piksel(x, 198, redPal[x + 5], greenPal[x + 5]); /**/

            piksel(x, 199, redPal[x], greenPal[x]); /**/

        }
        for (int y = wys - 3; y > 1; y--) {
            for (int x = 6; x < szer - 7; x++) {
                int lowwerRed[] = scrRed[y + 1];
                int dlowwerRed[] = scrRed[y + 2];
                int lowwerGreen[] = scrGreen[y + 1];
                int dlowwerGreen[] = scrRed[y + 2];

                tmpRed[x] = (lowwerRed[x] * 20 + lowwerRed[x + 1] * 7 + lowwerRed[x - 1] * 7) + (dlowwerRed[x] * 14 + dlowwerRed[x + 1] * 6 + dlowwerRed[x - 1] * 6);
                tmpRed[x] /= 60;

                tmpGreen[x] = (lowwerGreen[x] * 20 + lowwerGreen[x + 1] * 7 + lowwerGreen[x - 1] * 7) + (dlowwerGreen[x] * 14 + dlowwerGreen[x + 1] * 6 + dlowwerGreen[x - 1] * 6);
                tmpGreen[x] /= 60;
            }
            for (int x = 1; x < szer - 2; x++) {
                piksel(x, y, tmpRed[x], tmpGreen[x]);
            }

        }

        fire_g();
    }

}
