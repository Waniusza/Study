package com.gut.waniusza.semestr_5.oojp.col_5;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author student
 */
public class RandomSet {
    
    public static void main(String args[]) {
        Random generator = new Random();
        Set<Integer>  result = new HashSet<>();
        while (result.size() < 10 ) {
            result.add(generator.nextInt(20) + 1);
        }
        System.out.print(result.toString());
    }
}
