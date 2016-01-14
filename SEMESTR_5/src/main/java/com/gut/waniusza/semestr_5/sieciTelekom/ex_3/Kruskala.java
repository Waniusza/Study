package com.gut.waniusza.semestr_5.sieciTelekom.ex_3;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author student
 */
public class Kruskala {

    private static final Logger log = LogManager.getLogger(Kruskala.class);

    List<Integer> vertxCollection;
    List<JsonObject> sortedEdgeList;

    public Kruskala(List<Integer> vertxCollection, List<JsonObject> sortedEdgeList) {
        this.vertxCollection = vertxCollection;
        this.sortedEdgeList = sortedEdgeList;
    }

    public JsonObject count() {
        List<JsonObject> trees = new ArrayList<>();
        Integer treeIndex;
        Iterator<JsonObject> edgeIterator = sortedEdgeList.iterator();

        while ((treeIndex = GraphHelper.resultFound(trees, vertxCollection.size())) == null) {
            JsonObject edge = edgeIterator.next();

            Integer toTreeIndex = GraphHelper.treeContainsVertxIndex(trees, edge.getInteger(GraphConst.EDGE_VERTX_TO));
            Integer fromTreeIndex = GraphHelper.treeContainsVertxIndex(trees, edge.getInteger(GraphConst.EDGE_VERTX_FROM));

            log.debug("Indeksy częsciowych grafów rozpinających : " + toTreeIndex + " :: " + fromTreeIndex + " :: ");

            if (toTreeIndex != null && fromTreeIndex != null && toTreeIndex.equals(fromTreeIndex)) {
                log.debug("Oba wierzchołki należą to dego samego częściowego grafu rozpinającego.");
                log.debug("Nic nie rób");
            } else if (toTreeIndex != null && fromTreeIndex != null) {
                log.debug("Początkowy wierzchołkek należy do pewnego częściowego grafu rozpinającego, końcowy nie przynależy do żadnego ");
                log.debug("Dołącz krawędź do grafu posiadającego początkowy wierzchołek");
                JsonObject treeTo = trees.get(toTreeIndex);
                JsonObject treeFrom = trees.get(fromTreeIndex);

                GraphHelper.connectTrees(treeTo, treeFrom);
                trees.remove(fromTreeIndex.intValue());
                trees.set(toTreeIndex, treeTo);
            } else if (toTreeIndex != null && fromTreeIndex == null) {
                log.debug("Końcowy wierzchołkek należy do pewnego częściowego grafu rozpinającego, początkowy nie przynależy do żadnego ");
                log.debug("Dołącz krawędź do grafu posiadającego końcowy wierzchołek");
                JsonObject treeTo = trees.get(toTreeIndex);
                JsonObject newTreeTo = GraphHelper.addEdgeToTree(treeTo, edge);
                trees.set(toTreeIndex, newTreeTo);
            } else if (toTreeIndex == null && fromTreeIndex != null) {
                log.debug("Oba wierzchołki należą do różnych częściowych grafów rozpinających");
                log.debug("Połącz grafy");

                JsonObject treeFrom = trees.get(fromTreeIndex);
                JsonObject newTreeFrom = GraphHelper.addEdgeToTree(treeFrom, edge);
                trees.set(fromTreeIndex, newTreeFrom);
            } else {
                log.debug("Żaden wierzchołków nie należy do istniejącego częściowego grafu rozpinającego");
                log.debug("Stwórz nowy graf");

                JsonObject newTree = new JsonObject()
                        .put(GraphConst.RESULT_VERTXS, new JsonArray()
                                .add(edge.getInteger(GraphConst.EDGE_VERTX_TO))
                                .add(edge.getInteger(GraphConst.EDGE_VERTX_FROM)))
                        .put(GraphConst.RESULT_EDGES, new JsonArray()
                                .add(edge));

                trees.add(newTree);
            }
            log.debug("Po obsłużeniu krawędzi : " + edge.encodePrettily());
            log.debug("Mam częściowe grafy rozpinające  : ");
            trees.forEach(tree -> {
                log.debug(tree);
            });
        };
        log.debug(" ========================================= OTRZYMAŁEM OSTATECZNY GRAF ROZINAJĄCY, ZAWIERAJĄCY WSZYSTKIE WIERZCHOŁKI ");

        return trees.get(treeIndex);
    }

}
