package com.gut.waniusza.semestr_5.sieciTelekom.ex_3;

import io.vertx.core.json.JsonObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author student
 */
public class Prima {
  private static final Logger log = LogManager.getLogger(Prima.class);

    List<JsonObject> kolejkaPriorytetowa = new LinkedList<>();
    Map<String, List<JsonObject>> mappedVertxs;

    public Prima(Map<String, List<JsonObject>> mappedVertxs) {
        this.mappedVertxs = mappedVertxs;
    }

    public JsonObject count() {
        sortujKolejkę();

        JsonObject wynik = GraphHelper.initTree();
        int ilośćWierzchołków = mappedVertxs.size();

        String MDR = mappedVertxs.keySet().iterator().next();
        
        log.debug("Startuje algorytm z wierzcholkiem: " + MDR);
        log.debug("Startuje algorytm z ilośćWierzchołków: " + ilośćWierzchołków);
        log.debug("Startuje algorytm z countSummaryLength(): " + GraphHelper.countSummaryLength(wynik));
        while (GraphHelper.countSummaryLength(wynik) != ilośćWierzchołków) {
            
            dodajDoKolejki(mappedVertxs.get(MDR));
            JsonObject krawedzDoDodania = kolejkaPriorytetowa.get(0);
            kolejkaPriorytetowa.remove(0);
            String dodanyWierzcholek;
            String zWierzcholka;
            if (!krawedzDoDodania.getInteger(GraphConst.EDGE_VERTX_FROM).toString().equals(MDR)) {
                dodanyWierzcholek = krawedzDoDodania.getInteger(GraphConst.EDGE_VERTX_FROM).toString();
                zWierzcholka = krawedzDoDodania.getInteger(GraphConst.EDGE_VERTX_TO).toString();
            } else {
                dodanyWierzcholek = krawedzDoDodania.getInteger(GraphConst.EDGE_VERTX_TO).toString();
                zWierzcholka = krawedzDoDodania.getInteger(GraphConst.EDGE_VERTX_FROM).toString();
            }

            log.debug("Dodaje krawedz : " + krawedzDoDodania);
            log.debug("DodanyWierzcholek : " + dodanyWierzcholek);
            log.debug("zWierzcholka : " + zWierzcholka);
            GraphHelper.addEdgeToTree(wynik, krawedzDoDodania);
            MDR = dodanyWierzcholek;
            
            mappedVertxs.remove(zWierzcholka);
        }
        return wynik;
    }

    private void dodajDoKolejki(List<JsonObject> krawedzie) {
        krawedzie.forEach(krawedz -> {
            kolejkaPriorytetowa.add(krawedz);
        });

        sortujKolejkę();
    }

    private void sortujKolejkę() {
        kolejkaPriorytetowa
                .sort(new GraphComparator());
    }

}
