package com.gut.waniusza.semestr_5.sieciTelekom.ex_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pair {

    private static final Logger log = LogManager.getLogger(Pair.class);


    public static boolean countPairForData(byte[] biteData) {
        boolean isPair = true;
        for (int i = 0; i < biteData.length; i++) {
            String binaryString = Integer.toBinaryString(biteData[i]);
            isPair = Boolean.logicalXor(isPair, countPairForBit(binaryString));
        }
        return isPair;
    }
    
    private static boolean countPairForBit(String binaryString) {
        int result = 0;
        byte[] bytes = binaryString.getBytes();
        for (int j = 0; j < bytes.length; j++) {
            result += bytes[j] - 48;
        }
        return result % 2 == 0;
    }

}
