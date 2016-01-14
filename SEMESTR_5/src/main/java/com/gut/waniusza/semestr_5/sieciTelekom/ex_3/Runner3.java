package com.gut.waniusza.semestr_5.sieciTelekom.ex_3;

import com.gut.waniusza.semestr_5.sieciTelekom.helper.FileHelper;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
        log.debug(" ========================================= PRZYGOTOWUJĘ KRAWĘDZIE ");
        byte[] biteData = FileHelper.getFileWithUtil(DATA_SRC);

        JsonArray edgeArray = new JsonArray(new String(biteData));
        log.debug("Załadowałem krawędzie -> " + edgeArray.encodePrettily());

        List<JsonObject> sortedEdgeList = edgeArray
                .stream()
                .map(r -> (JsonObject) r)
                .sorted(new GraphComparator())
                .collect(Collectors.toList());

        List<Integer> vertxCollection = edgeArray
                .stream()
                .flatMap(graph -> {
                    int v1 = ((JsonObject) graph).getInteger(GraphConst.EDGE_VERTX_FROM);
                    int v2 = ((JsonObject) graph).getInteger(GraphConst.EDGE_VERTX_TO);
                    return Stream.of(v1, v2);
                })
                .distinct()
                .collect(Collectors.toList());

        List<JsonObject> mappedVertxs = edgeArray
                .stream()
                .flatMap(graph -> {
                    JsonObject j1 = new JsonObject()
                            .put("vrtx", ((JsonObject) graph).getInteger(GraphConst.EDGE_VERTX_FROM).toString())
                            .put("graph", graph);
                    JsonObject j2 = new JsonObject()
                            .put("vrtx", ((JsonObject) graph).getInteger(GraphConst.EDGE_VERTX_TO).toString())
                            .put("graph", graph);
                    
                    return Stream.of(j1, j2);
                })
                .collect(Collectors.toList());
        
        mappedVertxs.forEach();
        
                .collect(Collectors.groupingBy(tmp -> tmp.getString("vrtx"), Collectors.mapping(tmp -> tmp.getJsonObject("graph"), Collectors.toList())));

        log.debug("Wydzielone wierzchołki -> " + vertxCollection);
        log.debug("Wydzielone i posortowane krawędzie -> " + sortedEdgeList);
        log.debug("Wierzchołki wraz z ich krawedzaimi -> " + mappedVertxs);

//        Kruskala kruskalaAlgorithm = new Kruskala(vertxCollection, sortedEdgeList);
//
//        JsonObject wynik = kruskalaAlgorithm.count();
//        log.debug("Ostateczny graf rozpinający: " + wynik.getJsonArray(GraphConst.RESULT_EDGES).encodePrettily());
//        log.debug("Ostateczną długość połączeń: " + GraphHelper.countSummaryLength(wynik));
        Prima primaAlgorithm = new Prima(mappedVertxs);
        JsonObject wynik = primaAlgorithm.count();
        log.debug("Ostateczny graf rozpinający: " + wynik.getJsonArray(GraphConst.RESULT_EDGES).encodePrettily());
        log.debug("Ostateczną długość połączeń: " + GraphHelper.countSummaryLength(wynik));

    }
}
