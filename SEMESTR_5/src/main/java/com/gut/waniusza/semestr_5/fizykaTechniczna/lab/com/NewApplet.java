/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 * http://lo28.internetdsl.pl/kolor/ogien.html
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
        try {
            fire_g(null);
        } catch (InterruptedException ex) {
            Logger.getLogger(NewApplet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    void fire_g(Thread thread) throws InterruptedException {
        int tmp;
        Calculator c1 = new Calculator(szer);
        Calculator c2 = new Calculator(szer);
        System.out.println("C1 start");
        c1.start();
        System.out.println("C2 start");
        c2.start();

        System.out.println("C1 join");
        c1.join();
        scr[wys - 1] = c1.getRes();
        System.out.println("C2 join");
        c2.join();
        scr[wys - 2] = c2.getRes();

        Calculator2 cz1 = new Calculator2(szer, wys, scr);
        System.out.println("Cz1 start");
        cz1.start();
        System.out.println("Cz1 join");
        cz1.join();
        scr = cz1.getScr();

        Drawer drawer = new Drawer(mapa, scr, szer, wys);
        if (thread != null) {
            System.out.println("drawer join");
            thread.join();
        }
        System.out.println("drawer start");
        drawer.start();

        fire_g(drawer);

    }

}
