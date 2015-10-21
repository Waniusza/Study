package com_3.calcs;

import com_3.struct.Config;
import com_3.struct.Piksel;

/**
 *
 * @author janusz
 */
public class FloorCalc extends Thread {

    private Piksel[] res;

    public FloorCalc() {
        this.res = new Piksel[Config.WIDTH];
    }

    private void genPalet() {
        
        for (int i = 0; i < 10; i++) {
            res[i] = new Piksel(0);
        }
        for (int i = 10; i < Config.WIDTH - 10; i++) {
            double wsp = 1 - Math.abs(i - (double) (Config.WIDTH / 2)) / (Config.WIDTH / 2);
            res[i] = new Piksel(Config.FLOOR_START + Math.random() * Config.FLOOR_RANDOM_RATIO + Config.FLOOR_PLACE_RATIO * wsp);
        }

        for (int i = Config.WIDTH - 10; i < Config.WIDTH; i++) {
            res[i] = new Piksel(0);
        }
    }

    public Piksel[] getRes() {
        return res;
    }

    @Override
    public void run() {
        genPalet();
    }

}
