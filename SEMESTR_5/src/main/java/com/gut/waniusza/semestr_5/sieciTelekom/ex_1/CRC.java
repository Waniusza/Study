package com.gut.waniusza.semestr_5.sieciTelekom.ex_1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CRC {

    private static final Logger log = LogManager.getLogger(CRC.class);


    public static int countCRCForData(byte[] byteData) {
        
        String biteData = "";
        
        for (int i = 0; i < byteData.length; i++) {
            biteData = biteData.concat(Integer.toBinaryString(byteData[i]));
//            moduloResult = (moduloResult + countPairForBit(binaryString)) % Config.MODULO_MAX;
        }
        log.debug(biteData);
        return 0;
    }
    
    private static int countPairForBit(String binaryString) {
        int result = 0;
        byte[] bytes = binaryString.getBytes();
        for (int j = 0; j < bytes.length; j++) {
            result += bytes[j] - 48;
        }
        return result;
    }

}
