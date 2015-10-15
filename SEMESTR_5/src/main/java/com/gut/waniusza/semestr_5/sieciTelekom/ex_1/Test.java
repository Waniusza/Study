package com.gut.waniusza.semestr_5.sieciTelekom.ex_1;

import com.gut.waniusza.semestr_5.sieciTelekom.helper.FileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

    private static final Logger log = LogManager.getLogger(Test.class);
    private static double chanceToWrong = 0.01;
    static final byte[] biteData = FileHelper.getFileWithUtil(Runner.DATA_SRC);
    static final Boolean correctResult =  Pair.countPairForData(biteData);

    public boolean runTest() {
        byte[] forcedData = forceWrongs(chanceToWrong);
        boolean isResultCorrect = correctResult.equals(Pair.countPairForData(forcedData));
        return isResultCorrect;
    }
    

    private byte[] forceWrongs(double chance) {
        byte[] result = biteData;
        for (int i = 0; i < result.length; i++) {
            double rand = Math.random();
//            log.debug(chance + " :: " + rand);
            if (rand < chance) {
                result[i] = (byte) ((biteData[i] + 1) % 2);
            }
        }
        return result;
    }

}
