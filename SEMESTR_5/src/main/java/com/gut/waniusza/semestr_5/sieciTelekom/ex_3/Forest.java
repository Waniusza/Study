package com.gut.waniusza.semestr_5.sieciTelekom.ex_3;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author student
 */
public class Forest {
    private Set<Integer> vertxs = new HashSet<>();
    private Integer weigthSummary = 0;

    public Forest(int firstVertx) {
        vertxs.add(firstVertx);
    }
    
    public Boolean checkIfContains (int vertx) {
        return vertxs.contains(vertx);
    }
    public void addVertx (int vertx) {
        vertxs.add(vertx);
    }
}
