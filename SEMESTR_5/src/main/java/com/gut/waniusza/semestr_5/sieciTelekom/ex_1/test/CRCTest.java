package com.gut.waniusza.semestr_5.sieciTelekom.ex_1.test;

import com.gut.waniusza.semestr_5.sieciTelekom.ex_1.Config;
import com.gut.waniusza.semestr_5.sieciTelekom.ex_1.algorithm.Modulo;
import com.gut.waniusza.semestr_5.sieciTelekom.ex_1.Runner;
import com.gut.waniusza.semestr_5.sieciTelekom.helper.FileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CRCTest {

    private static final Logger log = LogManager.getLogger(CRCTest.class);
    static final byte[] biteData = FileHelper.getFileWithUtil(Runner.DATA_SRC);
    static final int correctResult = Modulo.countModuloForData(biteData);
    private int fails = 0;
    private static int countFails = 0;
    private static int count = 0;

    public void runTest() {
        byte[] forcedData = forceWrongs();
        int forcedResult = Modulo.countModuloForData(forcedData);
        boolean isResultCorrect = correctResult == forcedResult;
        if (fails > 0 && isResultCorrect) {
            log.warn("=========== metoda sądzi że wynik jest " + (isResultCorrect ? " OK " : " WRONG") + " mimo " + fails + " zakłóceń");
        }
    }

    private byte[] forceWrongs() {
        byte[] result = biteData;
        for (int i = 0; i < result.length; i++) {
            double rand = Math.random();
//            log.debug(chance + " :: " + rand);
            if (rand < Config.CNANCE_TO_WRONG) {
                fails++;
                result[i] = (byte) ((biteData[i] + 49) % 2 + 48);
            }
        }
        return result;
    }

    public static int getCount() {
        return count;
    }

    public static int getCountFails() {
        return countFails;
    }
}
