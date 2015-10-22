/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.sieciTelekom.ex_1;

import com.gut.waniusza.semestr_5.sieciTelekom.helper.FileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author janusz BARTOSZ REICHEL REICHEL@mif.pg.gda.pl GB 409
 * DBSERVER.mif.pg.gda.pl/st.aspx
 */
public class Runner {

    private static final Logger log = LogManager.getLogger(Runner.class);

    public static String DATA_SRC = "data.txt";
    public static final Boolean RUN_PAIR = true;
    public static final Boolean TEST_PAIR = true;
    public static final Boolean RUN_MODULO = false;
    public static final Boolean TEST_MODULE = false;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        log.debug(" init ");
        if (RUN_PAIR) {
            runPairBit();
        }
        if (TEST_PAIR) {
            for (int i = 0; i < 100; i++) {
                PairTest pairTest = new PairTest();
                pairTest.runTest();
            }
        }
        if (RUN_MODULO) {
            runModuloBit();
        }
        if (TEST_MODULE) {
            for (int i = 0; i < 100; i++) {
                ModuloTest moduloTest = new ModuloTest();
                moduloTest.runTest();
            }
        }

    }

    private static void runPairBit() {
        boolean isPair;

        // Get data from File
        byte[] biteData = FileHelper.getFileWithUtil(DATA_SRC);
        // Count ones from data
        log.debug("=========== Pobrano plik o długości : " + biteData.length);
        isPair = Pair.countPairForData(biteData);
        // Save result into new file
        log.debug("SUMMARRY  " + (isPair ? " is pair" : " is not pair"));
        FileHelper.saveResult(isPair, "bitPair");
    }

    private static void runModuloBit() {
        int modulo;

        // Get data from File
        byte[] biteData = FileHelper.getFileWithUtil(DATA_SRC);
        // Count modulo from data
        log.debug("=========== Pobrano plik o długości : " + biteData.length);
        modulo = Modulo.countModuloForData(biteData);
        // Save result into new file
        log.debug("MODULO " + modulo);
        FileHelper.saveResult(modulo, "modulo");
    }
}

/**
 *
 * 1 - 1 - 0
 * 1 - 0 - 1
 * 0 - 1 - 1
 * 0 - 0 - 0
 *
 */
//
//0000011000010111: 1001
//     1001.......
//        ---.....
//     ==1100.....
//       1001.....
//          ---...
//       ==1110...
//         1001...
//            --..
//         =1011..
//          1001..
//             ---
//          ==1011
//            1001
//              --    
//            ==10 = 2 =
// = reszta z dzielenia
