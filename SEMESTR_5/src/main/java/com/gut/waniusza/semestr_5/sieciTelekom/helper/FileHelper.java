/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.sieciTelekom.helper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author student
 */
public class FileHelper {

    private static final String RESOURCES = "src/main/resources/";
    private static final Logger log = LogManager.getLogger(FileHelper.class);

    public static byte[] getFileWithUtil(String fileName) {
        FileHelper fileHelper = new FileHelper();
        byte[] result = null;
        ClassLoader classLoader = fileHelper.getClass().getClassLoader();
        try {
            result = IOUtils.toByteArray(classLoader.getResourceAsStream(fileName));
        } catch (IOException ex) {
            log.warn("B\u0142\u0105d wczytywania pliku - IOException! ");
            log.warn("B\u0142\u0105d wczytywania pliku! ", ex);
        } catch (Exception ex) {
            log.warn("B\u0142\u0105d wczytywania pliku - Exception! ");
            log.warn("B\u0142\u0105d wczytywania pliku! ", ex);
        }
        return result;
    }

    public static void saveResult(Object data, String name) {
        try {
            FileWriter fstream = new FileWriter(RESOURCES + "ex_1out/out_" + name + "_" + System.currentTimeMillis() + ".txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(data.toString());
            out.close();
            log.debug("Zapis pliku zakończony powodzeniem");
        } catch (IOException ex) {
            log.warn("B\u0142\u0105d wczytywania pliku - IOException! ");
            log.warn("B\u0142\u0105d wczytywania pliku! ", ex);
        } catch (Exception ex) {
            log.warn("B\u0142\u0105d zapisu pliku - Exception! ");
            log.warn("B\u0142\u0105d zapisu pliku! ", ex);
        }
    }

}
