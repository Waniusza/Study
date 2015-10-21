package com.gut.waniusza.semestr_5.sieciTelekom.ex_1;

import com.gut.waniusza.semestr_5.sieciTelekom.helper.FileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PairTest {

    private static final Logger log = LogManager.getLogger(PairTest.class);
    private static double chanceToWrong = 0.01;
    static final byte[] biteData = FileHelper.getFileWithUtil(Runner.DATA_SRC);
    static final Boolean correctResult = Pair.countPairForData(biteData);

    public void runTest() {
        byte[] forcedData = forceWrongs();
        boolean isResultCorrect = correctResult.equals(Pair.countPairForData(forcedData));
        log.debug(" message is " + (isResultCorrect ? " OK " : " WRONG"));
    }

    private byte[] forceWrongs() {
        byte[] result = biteData;
        for (int i = 0; i < result.length; i++) {
            double rand = Math.random();
//            log.debug(chance + " :: " + rand);
            if (rand < Config.CNANCE_TO_WRONG) {
                result[i] = (byte) ((biteData[i] + 1) % 2);
            }
        }
        return result;
    }

}
