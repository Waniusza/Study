/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.fizykaTechniczna.lab.prezentation.calcs;

import com.gut.waniusza.semestr_5.fizykaTechniczna.lab.prezentation.struct.Config;
import com.gut.waniusza.semestr_5.fizykaTechniczna.lab.prezentation.struct.Piksel;

/**
 *
 * @author janusz
 */
public class RealInteancityCalc extends Thread {

    private Piksel oldScr[][];
    private int scr[][];

    public RealInteancityCalc(Piksel oldScr[][]) {
        this.oldScr = oldScr;
        scr = new int[Config.HEIGTH][Config.WIDTH];
    }

    private void calc() {
        int newX, newY;
        for (int y = 0; y < Config.HEIGTH; y++) {
            for (int x = 0; x < Config.WIDTH; x++) {
                Piksel tempPiksel = oldScr[y][x];
                newX = x + tempPiksel.getShiftX();
                newY = y + tempPiksel.getShiftY();
                scr[y][x] += tempPiksel.getColorIntensity() * Config.BROWN_WEIGHT_REVERT;
                if (newY > 0 && newY < Config.HEIGTH && newX > 0 && newX < Config.WIDTH) {
                    scr[newY][newX] += tempPiksel.getColorIntensity() * Config.BROWN_WEIGHT;
                }
            }
        }
        for (int y = 0; y < Config.HEIGTH; y++) {
            for (int x = 0; x < Config.WIDTH; x++) {
                this.oldScr[y][x].setColorIntensity(scr[y][x]);
            }
        }
        
        // save real color intensity to Piksels
        for (int y = 0; y < Config.HEIGTH; y++) {
            for (int x = 0; x < Config.WIDTH; x++) {
                this.oldScr[y][x].setColorIntensity(scr[y][x]);
            }
        }
        
        
        //imit dyfusion
        for (int y = 0; y < Config.HEIGTH-2; y++) {
            for (int x = 0; x < Config.WIDTH; x++) {
                this.oldScr[y][x] = this.oldScr[y+ Config.DIFUSION_SPEED][x];
            }
        }
    }

    public int[][] getRealScr() {
        return scr;
    }

    @Override
    public void run() {
        calc();
    }
}
