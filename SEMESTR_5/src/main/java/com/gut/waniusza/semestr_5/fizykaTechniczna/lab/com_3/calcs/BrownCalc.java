package com_3.calcs;

import com_3.struct.Config;
import com_3.struct.Piksel;

/**
 *
 * https://pl.wikipedia.org/wiki/Ruchy_Browna
 * https://pl.wikipedia.org/wiki/Proces_Wienera
 * 
 * 
 * http://prac.im.pwr.wroc.pl/~kwasnicki/stuff/Poznan.pdf
 * http://eti.pg.edu.pl/documents/176546/25263566/SZ_wyklad3.pdf
 * http://mst.mimuw.edu.pl/lecture.php?lecture=was&part=Ch1  < - trudny język
 * @author janusz
 */
public class BrownCalc extends Thread {

    private Piksel scr[][];

    public BrownCalc(Piksel old[][]) {
        scr = old;
    }

    private void calc() {
        for (int y = 0; y < Config.HEIGTH - 3; y++) {
            for (int x = 2; x < Config.WIDTH - 3; x++) {
                scr[y][x].addShift(Math.random() * Config.BROWN_MAX_PER_TURN - Config.BROWN_MAX_PER_TURN/2, Math.random() * Config.BROWN_MAX_PER_TURN - Config.BROWN_MAX_PER_TURN/2);
                scr[y][x].addShift(Math.random() * Config.BROWN_MAX_PER_TURN - Config.BROWN_MAX_PER_TURN/2, Math.random() * Config.BROWN_MAX_PER_TURN - Config.BROWN_MAX_PER_TURN/2);
            }
        }
    }

    @Override
    public void run() {
        calc();
    }
}
