package com.gut.waniusza.semestr_5.fizykaTechniczna.lab.prezentation;

import com.gut.waniusza.semestr_5.fizykaTechniczna.lab.prezentation.calcs.BrownCalc;
import com.gut.waniusza.semestr_5.fizykaTechniczna.lab.prezentation.calcs.FloorCalc;
import com.gut.waniusza.semestr_5.fizykaTechniczna.lab.prezentation.calcs.IntencityCalc;
import com.gut.waniusza.semestr_5.fizykaTechniczna.lab.prezentation.calcs.RealInteancityCalc;
import com.gut.waniusza.semestr_5.fizykaTechniczna.lab.prezentation.struct.Config;
import com.gut.waniusza.semestr_5.fizykaTechniczna.lab.prezentation.struct.Piksel;
import java.applet.Applet;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 * http://lo28.internetdsl.pl/kolor/ogien.html
 *
 * @author janusz
 */
public class NewApplet extends Applet {

    Graphics mapa;

    Piksel[][] clearScr = new Piksel[Config.HEIGTH][Config.WIDTH];
    int[][] brownScr = new int[Config.HEIGTH][Config.WIDTH];

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
        for (int i = 0; i < Config.HEIGTH; i++) {
            for (int j = 0; j < Config.WIDTH; j++) {
                clearScr[i][j] = new Piksel(0);
            }
        }
    }

    void fire_g(Thread thread) throws InterruptedException {
        int tmp;
        for (int i = 0; i < Config.FLOORINIT_ROWS; i++) {
            FloorCalc floorCalc = new FloorCalc();
            floorCalc.start();
            floorCalc.join();
            clearScr[Config.HEIGTH - i - 1] = floorCalc.getRes();
        }


        IntencityCalc cz1 = new IntencityCalc(clearScr);
        BrownCalc brownCalc = new BrownCalc(clearScr);
//        System.out.println("Cz1 start");
        cz1.start();
        brownCalc.start();
//        System.out.println("Cz1 join");
        cz1.join();
        brownCalc.join();

        RealInteancityCalc realCalc = new RealInteancityCalc(clearScr);
//        System.out.println("realCalc start");
        realCalc.start();
//        System.out.println("realCalc join");
        realCalc.join();
//        clearScr = cz1.getScr();

        Drawer drawer = new Drawer(mapa, realCalc.getRealScr());
        if (thread != null) {
//            System.out.println("drawer join");
            thread.join();
            thread = null;
        }
//        System.out.println("drawer start");
        drawer.start();
        cz1 = null;
        realCalc = null;

        fire_g(drawer);
    }

}
