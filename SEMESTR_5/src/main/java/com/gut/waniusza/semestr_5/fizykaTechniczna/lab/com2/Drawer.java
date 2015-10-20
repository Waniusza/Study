package com2;

import com2.struct.Config;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author janusz
 */
public class Drawer extends Thread {

    Graphics mapa;
    int scr[][];
    public Drawer(Graphics mapa, int[][] scr) {
        this.mapa = mapa;
        this.scr = scr;
    }

    private void draw() {
        for (int x = 0; x < Config.HEIGTH; x++) {
            for (int y = 0; y < Config.WIDTH; y++) {
                int green = scr[x][y];
                piksel(y, x, (green>255?255:green<0?0:green));
            }
        }
    }

    @Override
    public void run() {
        draw();
    }

    void piksel(int x, int y, int kolor) {
        if (kolor == 0) {
            mapa.setColor(new Color(0, 0, 0));
        } else {
            mapa.setColor(new Color(255, 255 - kolor, 0));
        }
        mapa.drawRect(x, y, 1, 1);
    }

}
