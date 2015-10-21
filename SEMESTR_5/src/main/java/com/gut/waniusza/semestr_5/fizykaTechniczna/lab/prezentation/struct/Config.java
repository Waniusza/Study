/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.fizykaTechniczna.lab.prezentation.struct;

/**
 *
 * @author janusz
 */
public class Config {

    // SCREEN config
    public static final int HEIGTH = 150;
    public static final int WIDTH = 300;
    public static final int WIDTH_HALF = WIDTH / 2;
    
    // rown motion congig
    public static final double BROWN_WEIGHT = 0.2;   
    public static final double BROWN_WEIGHT_REVERT = 1 - BROWN_WEIGHT;
    public static final double BROWN_MAX_PER_TURN = 3;
    
    // FLOOR GENERATOR
    public static final int FLOORINIT_ROWS = 4 ;
    public static final int FLOOR_FREE_SPACE = 20 ;
    public static final int FLOOR_START = 256 * 0 / 5 ;
    public static final int FLOOR_PLACE_RATIO = 256 * 3 / 5;
    public static final int FLOOR_RANDOM_RATIO = 255 - FLOOR_PLACE_RATIO - FLOOR_START;
    
    public static final int SHIFT_BORDER_DECREASE = 60;
    public static final int SHIFT_DECREASE = 2;
    public static final double COLOR_INTENCITY_DECREASE = 2;
    public static final int DIFUSION_SPEED = 1;

    /**
     * [1][1] i [1][3] muszą być symetryczne dwuktornie mniejsze od [1][2]
     *
    public static final double BROWN_WEIGHT_REVERT = 1 - BROWN_WEIGHT;
    public static final int WIDTH_HALF = WIDTH / 2;

     * [2][0] i [2][5] muszą być symetryczne dwuktornie mniejsze od [2][2]
     *
     */
    public static final int[][] TRANSMISSION_RATIO = {
        {0, 10, 0, 10, 0},
        {0, 15, 30, 15, 0},
        {30, 8, 60, 8, 30}
    };
    /**
     * zmienna BARDZO wrażliwa! Pwinna być skoordynowana z
     * Gonfig.TRANSMISSION_RATIO oraz IntencityCalc.calc() !!
     *
     * ze względu na zamienne zastosowanie wspl i revWspl należy pominąć
     * współczynniki symetryczne
     */
    public static final int TRANSMISSION_SUM
            = TRANSMISSION_RATIO[0][0] + TRANSMISSION_RATIO[0][1] + TRANSMISSION_RATIO[0][2] + TRANSMISSION_RATIO[0][3] + TRANSMISSION_RATIO[0][4]
            + TRANSMISSION_RATIO[1][0] + TRANSMISSION_RATIO[1][2] + TRANSMISSION_RATIO[1][4]
            + TRANSMISSION_RATIO[2][1] + TRANSMISSION_RATIO[2][2] + TRANSMISSION_RATIO[2][3];

 

}
