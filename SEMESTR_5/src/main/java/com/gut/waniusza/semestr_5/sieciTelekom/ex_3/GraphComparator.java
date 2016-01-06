package com.gut.waniusza.semestr_5.sieciTelekom.ex_3;

import io.vertx.core.json.JsonObject;
import java.util.Comparator;

/**
 *
 * @author student
 */
public class GraphComparator implements Comparator<JsonObject> {

    GraphComparator() {
        super();
    }

    @Override
    public int compare(JsonObject t, JsonObject t1) {
        return t.getInteger("lengthWeigth") - t1.getInteger("lengthWeigth");
    }

}
