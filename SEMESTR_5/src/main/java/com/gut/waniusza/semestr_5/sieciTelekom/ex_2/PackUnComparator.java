package com.gut.waniusza.semestr_5.sieciTelekom.ex_2;

import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author student
 */
public class PackUnComparator implements Comparator<Pack>{

    static final Random random = new Random();
    @Override
    public int compare(Pack t, Pack t1) {
        return 50 - random.nextInt(100);
    }
    
}
