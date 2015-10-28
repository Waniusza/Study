package com.gut.waniusza.semestr_5.sieciTelekom.ex_1;

import com.gut.waniusza.semestr_5.sieciTelekom.helper.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Modulo {

    private static final Logger log = LogManager.getLogger(Modulo.class);


    public static int countModuloForData(byte[] biteData) {
        
        int moduloResult = 0;
        for (int i = 0; i < biteData.length; i++) {
            String binaryString = Integer.toBinaryString(biteData[i]);
            moduloResult = (moduloResult + countPairForBit(binaryString)) % Config.MODULO_MAX;
        }
        return moduloResult;
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
