package com.gut.waniusza.semestr_5.sieciTelekom.ex_1;

import com.gut.waniusza.semestr_5.sieciTelekom.helper.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CRC {

    private static final Logger log = LogManager.getLogger(CRC.class);

    public static String countCRCForData(byte[] byteData) {

        String binaryData = "";

        log.debug("CRC  => " + byteData.length);
        for (int i = 0; i < byteData.length; i++) {
            binaryData = binaryData.concat(Integer.toBinaryString(byteData[i]));
        }
        log.debug("CRC  => DONE1");
        return getCRC(binaryData);
    }

    private static String getCRC(String binaryString) {
        String result = "";
        byte[] bytes = binaryString.getBytes();
        for (int i = 0; i < bytes.length - Config.CRC.length; i++) {
            if (bytes[i] == '1') {
                for (int j = 0; j < Config.CRC.length; j++) {
                    bytes[i + j] = (byte) (((bytes[i + j] + Config.CRC[j] - 48) % 2) + 48);
                }
            }
        }

        result = new String(bytes).substring(bytes.length - Config.CRC.length - 1);
        log.debug("CRC  => DONE2");
        return result;
    }

}
