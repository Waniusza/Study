package com.gut.waniusza.semestr_5.sieciTelekom.ex_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pair {
    private static final String resources = "src/main/resources/";
    private static final Logger log = LogManager.getLogger(Pair.class);

    public byte[] getFileWithUtil(String fileName) {
        byte[] result = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toByteArray(classLoader.getResourceAsStream(fileName));
        } catch (IOException ex) {
            log.warn("Błąd wczytywania pliku - IOException! ");
            log.warn("Błąd wczytywania pliku! ", ex);
        } catch (Exception ex) {
            log.warn("Błąd wczytywania pliku - Exception! ");
            log.warn("Błąd wczytywania pliku! ", ex);
        }
        return result;
    }

    public boolean countPair(String binaryString) {
        int result = 0;

        byte[] bytes = binaryString.getBytes();
        for (int j = 0; j < bytes.length; j++) {
            result += bytes[j] - 48;
        }
        return result % 2 == 0;
    }

    public void saveResult(Boolean result) {
        try {
            // Create file 
            FileWriter fstream = new FileWriter(resources + "out_" + System.currentTimeMillis() + ".txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(result.toString());
            //Close the output stream
            out.close();
            log.warn("Błąd zapisu pliku - Exception! ");
        } catch (Exception ex) {//Catch exception if any
            log.warn("Błąd zapisu pliku - Exception! ");
            log.warn("Błąd zapisu pliku! ", ex);
        }

    }

}

/**
 * value = 1011011011 wartość pozycji x = value
 *
 */
