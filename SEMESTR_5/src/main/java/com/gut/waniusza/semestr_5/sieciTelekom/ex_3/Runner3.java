package com.gut.waniusza.semestr_5.sieciTelekom.ex_3;

import com.gut.waniusza.semestr_5.sieciTelekom.helper.FileHelper;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author janusz BARTOSZ REICHEL REICHEL@mif.pg.gda.pl GB 409
 * http://dbserver.mif.pg.gda.pl/st/l3.pdf
 */
public class Runner3 {

    private static final Logger log = LogManager.getLogger(Runner3.class);

    public static String DATA_SRC = "sieci/graf.json";

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        log.debug(" init ");
        byte[] biteData = FileHelper.getFileWithUtil(DATA_SRC);

        JsonArray graphArray = new JsonArray(new String(biteData));
        log.debug("Załadowałem grafy -> " + graphArray.encodePrettily());

        List<Object> sortedGraphsList = graphArray
                .stream()
                .sorted((a, b) -> {
                    return ((JsonObject) a).getInteger("lengthWeigth") - ((JsonObject) b).getInteger("lengthWeigth");
                })
                .collect(Collectors.toList());
        
        List<Integer> vertxCollection = graphArray
                .stream()
                .flatMap(graph -> {
                    int v1 = ((JsonObject) graph).getInteger("vertxFrom");
                    int v2 = ((JsonObject) graph).getInteger("vertxTo");
                    return Stream.of(v1, v2);
                })
                .distinct()
                .collect(Collectors.toList());
        JsonArray sortedGraphs = new JsonArray(sortedGraphsList);
        log.debug("Wydzielone wierzchołki -> " + vertxCollection);   
        log.debug("Posortowaem grafy -> " + sortedGraphs.encodePrettily());   
        
    }

}
