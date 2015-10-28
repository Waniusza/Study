package com.gut.waniusza.semestr_5.sieciTelekom.ex_1;

import com.gut.waniusza.semestr_5.sieciTelekom.helper.Config;
import com.gut.waniusza.semestr_5.sieciTelekom.helper.FileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CRCTest {

    private static final Logger log = LogManager.getLogger(CRCTest.class);
    static final byte[] biteData = FileHelper.getFileWithUtil(Runner.DATA_SRC);
    static final int correctResult = Modulo.countModuloForData(biteData);
    private int fails = 0;

    public void runTest() {
        byte[] forcedData = forceWrongs();
        int forcedResult = Modulo.countModuloForData(forcedData);
        boolean isResultCorrect = correctResult == forcedResult;
        log.debug("=========== wprowadzono zakłóceń: " + fails);
        log.debug("=========== metoda sądzi że wynik jest " + (isResultCorrect ? " OK " : " WRONG"));
    }

    private byte[] forceWrongs() {
        byte[] result = biteData;
        for (int i = 0; i < result.length; i++) {
            double rand = Math.random();
//            log.debug(chance + " :: " + rand);
            if (rand < Config.CNANCE_TO_WRONG) {
                fails++;
                result[i] = (byte) ((biteData[i] + 1) % 2);
            }
        }
        return result;
    }

}
