package com.gut.waniusza.semestr_5.fizykaTechniczna.lab.com_2.calcs;

import com.gut.waniusza.semestr_5.fizykaTechniczna.lab.com_2.struct.Config;
import com.gut.waniusza.semestr_5.fizykaTechniczna.lab.com_2.struct.Piksel;

/**
 *
 * @author janusz
 */
public class IntencityCalc extends Thread {

    static Piksel scr[][];

    public IntencityCalc(Piksel old[][]) {
        scr = old;
    }

    private void calc() {
        for (int y = 0; y <= Config.HEIGTH - 3; y++) {
            Piksel current[] = scr[y];
            Piksel lowwer[] = scr[y + 1];
            Piksel dlowwer[] = scr[y + 2];

            for (int x = 2; x < Config.WIDTH - 3; x++) {
                double tmp;
                double wspl = 1 - Math.abs(x - Config.WIDTH_HALF) / Config.WIDTH_HALF;
                double revWspl = (1 - wspl);
                tmp = current[x - 2].getColorIntensity() * Config.TRANSMISSION_RATIO[0][0]
                        + current[x - 1].getColorIntensity() * Config.TRANSMISSION_RATIO[0][1]
                        + current[x].getColorIntensity() * Config.TRANSMISSION_RATIO[0][2]
                        + current[x + 1].getColorIntensity() * Config.TRANSMISSION_RATIO[0][3]
                        + current[x + 2].getColorIntensity() * Config.TRANSMISSION_RATIO[0][4];

                tmp += lowwer[x - 2].getColorIntensity() * Config.TRANSMISSION_RATIO[1][0]
                        + lowwer[x - 1].getColorIntensity() * revWspl * Config.TRANSMISSION_RATIO[1][1]
                        + lowwer[x].getColorIntensity() * wspl * Config.TRANSMISSION_RATIO[1][2]
                        + lowwer[x + 1].getColorIntensity() * revWspl * Config.TRANSMISSION_RATIO[1][3]
                        + lowwer[x + 2].getColorIntensity() * Config.TRANSMISSION_RATIO[1][4];

                tmp += dlowwer[x - 2].getColorIntensity() * revWspl * Config.TRANSMISSION_RATIO[2][0]
                        + dlowwer[x - 1].getColorIntensity() * Config.TRANSMISSION_RATIO[2][1]
                        + dlowwer[x].getColorIntensity() * wspl * Config.TRANSMISSION_RATIO[2][2]
                        + dlowwer[x + 1].getColorIntensity() * Config.TRANSMISSION_RATIO[2][3]
                        + dlowwer[x + 2].getColorIntensity() * revWspl * Config.TRANSMISSION_RATIO[2][4];
                tmp /= Config.TRANSMISSION_SUM;
                scr[y][x].setColorIntensity(tmp);
            }
        }
    }

    @Override
    public void run() {
        calc();
    }
}
