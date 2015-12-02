package com.gut.waniusza.semestr_5.sieciTelekom.ex_2;

import java.util.Comparator;

/**
 *
 * @author student
 */
public class PackComparator implements Comparator<Pack>{

    @Override
    public int compare(Pack t, Pack t1) {
        return t.getPackNumber() - t1.getPackNumber();
    }
    
}
