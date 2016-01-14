package com.gut.waniusza.semestr_5.sieciTelekom.ex_3;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author student
 */
public class GraphHelper {

    static Integer treeContainsVertxIndex(List<JsonObject> results, int vertxNr) {
        Integer res = null;
        int iteration = 0;
        Iterator<JsonObject> iterator = results.iterator();
        while (iterator.hasNext() && res == null) {
            JsonObject result = iterator.next();
            if (result.getJsonArray(GraphConst.RESULT_VERTXS).contains(vertxNr)) {
                res = iteration;
            }
            iteration++;
        }
        return res;
    }

    static Integer resultFound(List<JsonObject> results, int vertxAmount) {
        Integer res = null;
        int iteration = 0;
        Iterator<JsonObject> iterator = results.iterator();
        while (iterator.hasNext() && res == null) {
            JsonObject result = iterator.next();
            if (result.getJsonArray(GraphConst.RESULT_VERTXS).size() == vertxAmount) {
                res = iteration;
            }
            iteration++;
        }
        return res;
    }

    static JsonObject connectTrees(JsonObject result1, JsonObject result2) {
        JsonArray vrtx2 = result2.getJsonArray(GraphConst.RESULT_VERTXS);
        result1.put(GraphConst.RESULT_VERTXS, result1.getJsonArray(GraphConst.RESULT_VERTXS).addAll(vrtx2));
        JsonArray edge2 = result2.getJsonArray(GraphConst.RESULT_EDGES);
        result1.put(GraphConst.RESULT_EDGES, result1.getJsonArray(GraphConst.RESULT_EDGES).addAll(edge2));
        return result1;
    }

    static JsonObject initTree() {
        return new JsonObject()
                .put(GraphConst.RESULT_VERTXS, new JsonArray())
                .put(GraphConst.RESULT_EDGES, new JsonArray());
    }

    static JsonObject addEdgeToTree(JsonObject result, JsonObject edge) {
        Integer v1 = edge.getInteger(GraphConst.EDGE_VERTX_FROM);
        Integer v2 = edge.getInteger(GraphConst.EDGE_VERTX_TO);
        JsonArray vrtx = result.getJsonArray(GraphConst.RESULT_VERTXS);
        if (!vrtx.contains(v1)) {
            vrtx.add(v1);
        }
        if (!vrtx.contains(v2)) {
            vrtx.add(v2);
        }
        result.put(GraphConst.RESULT_VERTXS, vrtx);
        result.put(GraphConst.RESULT_EDGES, result.getJsonArray(GraphConst.RESULT_EDGES).add(edge));
        return result;
    }

    static Integer countSummaryLength(JsonObject resultTree) {
        Integer result = 0;
        JsonArray edges = resultTree.getJsonArray(GraphConst.RESULT_EDGES);
        Iterator<Object> iterator = edges.iterator();

        while (iterator.hasNext()) {
            result += ((JsonObject) iterator.next()).getInteger(GraphConst.EDGE_LENGTH);
        }

        return result;

    }

}
