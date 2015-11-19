package com.gut.waniusza.semestr_5.sieciTelekom.ex_2;

import com.gut.waniusza.semestr_5.sieciTelekom.ex_1.Runner;
import com.gut.waniusza.semestr_5.sieciTelekom.helper.BinaryHelper;
import com.gut.waniusza.semestr_5.sieciTelekom.helper.FileHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author janusz http://dbserver.mif.pg.gda.pl/st/l2.pdf
 */
public class Runner2 {

    public static String DATA_SRC = "in.jpg";

    private static final Logger log = LogManager.getLogger(Runner2.class);

    static final byte[] biteData = FileHelper.getFileWithUtil(DATA_SRC);

    public static void main(String[] args) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(biteData);

        final int packagesCount = (biteData.length / Config.MAX_PACKAGES_SIZE);

        byte[] dataToPack = new byte[Config.MAX_PACKAGES_SIZE];
        List<Pack> packs = new ArrayList<>();
        Pack tmpPack;
        int packNumber = 0;
        while ( packNumber != packagesCount ) {
            bis.read(dataToPack, 0, Config.MAX_PACKAGES_SIZE);
            tmpPack = new Pack(packNumber++, dataToPack, packagesCount);
            packs.add(tmpPack);
            log.debug(tmpPack);
        }

        log.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        log.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Ztworzenie ostatniej paczki, o zmniejszonym rozmiarze 
        List<Integer> lastDatas = new ArrayList<>();
        byte[] tmp = new byte[1];
        while ((bis.read(tmp, 0, 1)) != -1) {
//            log.debug("tmp -> " + BinaryHelper.toBinary(tmp));
            lastDatas.add(new Integer(tmp[0]));
        }
        byte[] lastBytes = new byte[lastDatas.size()];
        for (int i = 0; i < lastBytes.length; i++) {
            lastBytes[i] = lastDatas.get(i).byteValue();
        }
        tmpPack = new Pack(packNumber++, lastBytes, packagesCount, lastBytes.length);
        log.debug(tmpPack);
        packs.add(tmpPack);

    }
}
