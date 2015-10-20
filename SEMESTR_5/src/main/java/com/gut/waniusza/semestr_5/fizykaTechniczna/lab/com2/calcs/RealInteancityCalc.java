/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com2.calcs;

import com2.struct.Config;
import com2.struct.Piksel;

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
                scr[y][x] += tempPiksel.getColorIntensity() * Config.BROWN_WEIGHT;
                scr[(newY > (Config.HEIGTH - 1) ? Config.HEIGTH - 1 : newY < 0 ? 0 : newY)][(newX > (Config.WIDTH - 1) ? Config.WIDTH - 1 : newX < 0 ? 0 : newX)] 
                        += tempPiksel.getColorIntensity() * Config.BROWN_WEIGHT_REVERT;
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
