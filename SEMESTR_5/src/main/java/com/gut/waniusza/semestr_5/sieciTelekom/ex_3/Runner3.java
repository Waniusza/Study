package com.gut.waniusza.semestr_5.sieciTelekom.ex_3;

import com.gut.waniusza.semestr_5.sieciTelekom.helper.FileHelper;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
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

        Map<Integer, Set> connectedVertexs = new HashMap<>();
        vertxCollection.forEach(vertxNr -> {
            connectedVertexs.put(vertxNr, new HashSet());
        });

        sortedGraphs.forEach(graph -> {
            JsonObject g = (JsonObject) graph;
            Integer v1 = g.getInteger("vertxFrom");
            Integer v2 = g.getInteger("vertxTo");
            
            Set V1Array = connectedVertexs.get(v1);
            Set V2Array = connectedVertexs.get(v2);
            Set newV1Array = V1Array.addAll(V2Array);
            Set newV2Array = V2Array.addAll(V1Array);
            connectedVertexs.put(v1, newV1Array);
            connectedVertexs.put(v2, newV2Array);
        });
        log.debug("Wydzielone krawędzie -> " + vertxCollection);
        log.debug("Posortowalem krawędzie -> " + sortedGraphs.encodePrettily());
        log.debug("Połączone krawędzie -> " + connectedVertexs);

    }

}
