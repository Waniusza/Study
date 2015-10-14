/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.sieciTelekom;

import com.gut.waniusza.semestr_5.sieciTelekom.ex_1.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author janusz BARTOSZ REICHEL REICHEL@mif.pg.gda.pl GB 409
 * DBSERVER.mif.pg.gda.pl/st.aspx
 */
public class Runner {

    private static final Logger log = LogManager.getLogger(Runner.class);

    private static String DATA_SRC = "data.txt";

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        log.debug(" init ");
        Pair obj = new Pair();
        boolean isPair = Boolean.TRUE;
        
        // Get data from File
        byte[] biteData = obj.getFileWithUtil(DATA_SRC);
        log.debug("TEST === " + biteData);
        
        // Count ones from data
        for (int i = 0; i < biteData.length; i++) {
            String binaryString = Integer.toBinaryString(biteData[i]);
            isPair = Boolean.logicalXor(isPair, obj.countPair(binaryString));
            log.debug(binaryString + (obj.countPair(binaryString) ? " is     pair" : " is not pair") + "  SUMMARRY" + (isPair ? " is pair" : " is not pair"));
        }
        
        
        // Save result into new file
        log.debug("SUMMARRY  " + (isPair ? " is pair" : " is not pair"));
        obj.saveResult(isPair);
        
        // Get random disruptions
        log.debug("Random 1" + Math.random());
        log.debug("Random 2" + Math.random());
        log.debug("Random 3" + Math.random());
    }
}

/**
 * 
 * 1 - 1  - 0
 * 1 - 0  - 1
 * 0 - 1  - 1
 * 0 - 0  - 0
 * 
 */
