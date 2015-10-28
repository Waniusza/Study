package com.gut.waniusza.semestr_5.sieciTelekom.ex_1;

import com.gut.waniusza.semestr_5.sieciTelekom.helper.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CRC {

    private static final Logger log = LogManager.getLogger(CRC.class);

    public static String countCRCForData(byte[] byteData) {

        String biteData = "";

        for (int i = 0; i < byteData.length; i++) {
            biteData = biteData.concat(Integer.toBinaryString(byteData[i]));

//            moduloResult = (moduloResult + countPairForBit(binaryString)) % Config.MODULO_MAX;
        }
        log.debug(biteData);
        return getCRC(biteData);
    }

    private static String getCRC(String binaryString) {
        String result = "";
        byte[] bytes = binaryString.getBytes();
        for (int i = 0; i < bytes.length - Config.CRC.length; i++) {
            if (bytes[i] == 1) {
                for (int j = 0; j < Config.CRC.length; j++) {
                    bytes[i + j] = (byte) ((bytes[i + j] + Config.CRC[j]) % 2);
                }
            }
            for (int z = 0; z < bytes.length; z++) {
                System.out.print(bytes[z]);
            }
            System.out.println("");
        }

        return result;
    }

}
