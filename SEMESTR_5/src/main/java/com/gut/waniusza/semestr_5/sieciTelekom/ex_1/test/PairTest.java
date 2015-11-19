package com.gut.waniusza.semestr_5.sieciTelekom.ex_1.test;

import com.gut.waniusza.semestr_5.sieciTelekom.ex_1.Config;
import com.gut.waniusza.semestr_5.sieciTelekom.ex_1.algorithm.Pair;
import com.gut.waniusza.semestr_5.sieciTelekom.ex_1.Runner;
import com.gut.waniusza.semestr_5.sieciTelekom.helper.FileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PairTest {

    private static final Logger log = LogManager.getLogger(PairTest.class);
    static final byte[] biteData = FileHelper.getFileWithUtil(Runner.DATA_SRC);
    static final Boolean correctResult = Pair.countPairForData(biteData);
    private int fails;
    private static int countFails = 0;
    private static int count = 0;
    public void runTest() {
        byte[] forcedData = forceWrongs();
        boolean isResultCorrect = correctResult.equals(Pair.countPairForData(forcedData));
        if (fails > 0 && isResultCorrect) {
            log.warn("=========== metoda sądzi że wynik jest " + (isResultCorrect ? " OK " : " WRONG") + " mimo " + fails + " błędów");
        }
    }

    private byte[] forceWrongs() {
        byte[] result = biteData;
        for (int i = 0; i < result.length; i++) {
            double rand = Math.random();
//            log.debug(chance + " :: " + rand);
            if (rand < Config.CNANCE_TO_WRONG) {
                fails++;
                result[i] = (byte) (((biteData[i]) % 2 ));
            };
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
