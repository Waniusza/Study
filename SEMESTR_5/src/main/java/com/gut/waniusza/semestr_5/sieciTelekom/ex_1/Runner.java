/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.sieciTelekom.ex_1;

import com.gut.waniusza.semestr_5.sieciTelekom.ex_1.Pair;
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

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        log.debug(" init ");
        run();

        Test test = new Test();

        for (int i = 0; i < 100; i++) {
            if (test.runTest()) {
                log.debug("Message is OK");
            } else {
                log.debug("Message is WRONG");
            }
        }
    }

    public static Boolean run() {
        Pair obj = new Pair();
        boolean isPair = Boolean.TRUE;

        // Get data from File
        byte[] biteData = FileHelper.getFileWithUtil(DATA_SRC);

        // Count ones from data
        isPair = Pair.countPairForData(biteData);

        // Save result into new file
        log.debug("SUMMARRY  " + (isPair ? " is pair" : " is not pair"));
        FileHelper.saveResult(isPair);

        return isPair;
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
